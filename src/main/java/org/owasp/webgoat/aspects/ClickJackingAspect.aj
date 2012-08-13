package com.aspects; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.thesis.aop.util.StopWatch;
 
public aspect ClickJackingAspect{ 
	Logger logger; 
	StopWatch watch; 
	 
	//Constuctor for the Aspect. I do some init of loggers and
	//such here.
	public ClickJackingAspect(){ 
		//PropertyConfigurator.configure("log4j.properties"); 
		logger = Logger.getLogger("clickJackingLogger"); 
		logger.info("Click Jacking Prevention Aspect Created"); 
		watch = new StopWatch(); 
	} 

	//Pointcut definition for the doGet method.
	// Notice I'm intercepting all calls to doGet and specifying the 
	// request and response parameters.
	pointcut clickJacking_addHeaderDoGet(HttpServletRequest req, 
		HttpServletResponse resp) : 
		execution(* doGet(HttpServletRequest, 
			HttpServletResponse)) && 
		args(req, resp);
		
	//This is the Advice for the above pointcut definition. 
	//It intercepts the response and request parameters.
	Object around(HttpServletRequest req, HttpServletResponse resp): 
		clickJacking_addHeaderDoGet(req, resp){
		watch.start();
		//Adding the header to the response object
		resp.addHeader( "X-FRAME-OPTIONS", "SAMEORIGIN" ); 
		
		watch.stop();
		logger.info(thisJoinPoint.getSourceLocation().getFileName() + 
			"_" + thisJoinPoint.getSourceLocation().getLine() + 
			"," + watch.getElapsedTime());			
		//This passes in the response object with the new header and
		//continues application execution flow as normal. 
		return proceed(req, resp);
	}
	
	//Below is the same as above but for the doPost method.
	
	pointcut clickJacking_addHeaderDoPost(HttpServletRequest req, 
		HttpServletResponse resp) : 
		execution(* doPost(HttpServletRequest, HttpServletResponse)) 
		&& args(req, resp);
		
	Object around(HttpServletRequest req, HttpServletResponse resp): 
		clickJacking_addHeaderDoPost(req, resp){
		watch.start();

		resp.addHeader( "X-FRAME-OPTIONS", "SAMEORIGIN" ); 
		
		watch.stop();
		logger.info(thisJoinPoint.getSourceLocation().getFileName() + 
		thisJoinPoint.getSourceLocation().getLine() + "," + 
		watch.getElapsedTime());			
		return proceed(req, resp);
	}
} 
