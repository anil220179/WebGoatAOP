package com.aspects; 
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.thesis.aop.util.StopWatch;
 
public aspect MitigateCSRFAspect{ 
	Logger logger; 
	StopWatch watch;
	
	//Constuctor for the Aspect. I do some init of loggers and
	//such here.
	public MitigateCSRFAspect(){ 
		//PropertyConfigurator.configure("log4j.properties"); 
		logger = Logger.getLogger("csrfMitigationLogger"); 
		logger.info("CSRF Prevention Aspect Created"); 
		watch = new StopWatch(); 
	} 
	
	
	pointcut csrf_interceptDoPost(HttpServletRequest req, 
		HttpServletResponse resp) :
			execution(* doPost(HttpServletRequest, 
				HttpServletResponse)) && args(req, resp);
	
	//This is the Advice for the above pointcut definition. 
	//It intercepts the response and request parameters.
	Object around(HttpServletRequest req, 
			HttpServletResponse resp): 
		csrf_interceptDoPost(req, resp){
		
		watch.start();
		logger.info("Inside of MitigateCSRF Advice");
		
		//Validation of salt currently on the request
		String saltFromRequest = 
			(String) req.getParameter("csrfSalt");
			Cache<String, Boolean> csrfCacheFromRequest = 
				(Cache<String, Boolean>)
				req.getSession().getAttribute("csrfCache");
		
		
		//If cache on session is not there, then it must be 
		//the first request. Therefore there would be no 
		//csrf token that exists yet.
		if(csrfCacheFromRequest != null){
	        if (saltFromRequest != null &&
	        	csrfCacheFromRequest.
	        	getIfPresent(saltFromRequest) != null){
	 
	            // If the salt is in the cache, we move on
	        	logger.info("SALT IS GOOD! " + saltFromRequest);
	        } else {
	            // Otherwise we log an error
	            logger.info("CSRF detected! Engage panic mode.");
	        }
		}
		
		
		//Setting the new salt
		Cache<String, Boolean> csrfCache = (Cache<String, Boolean>)
			req.getSession().getAttribute("csrfCache");
		
        if (csrfCache == null){
        	csrfCache = CacheBuilder.newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(30, TimeUnit.MINUTES)
                .build();
        	
        	logger.info("Setting csrfCache: " + csrfCache);
            req.getSession().setAttribute("csrfCache", csrfCache);
        }
		
        String salt = RandomStringUtils.random(20, 0, 0, 
        		true, true, null, new SecureRandom());
        csrfCache.put(salt, Boolean.TRUE);
        
        //Use this on the JSP
        logger.info("Setting CSRF Salft: " + salt);
        req.setAttribute("csrfSalt", salt);
        
		watch.stop();
		logger.info(thisJoinPoint.getSourceLocation().getFileName() + 
			"_" + thisJoinPoint.getSourceLocation().getLine() + 
			"," + watch.getElapsedTime());	
		
		//This passes in the response object with the new header and
		//continues application execution flow as normal. 
		return proceed(req, resp);
	}
} 
