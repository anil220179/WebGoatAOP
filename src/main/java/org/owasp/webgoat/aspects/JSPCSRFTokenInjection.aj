package com.aspects; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import org.apache.log4j.Logger;

import com.thesis.aop.util.StopWatch;
 
public aspect JSPCSRFTokenInjection{ 
	Logger logger; 
	StopWatch watch;
	
	private String currentCSRFToken = null;
	 
	//Constuctor for the Aspect. I do some init 
	//of loggers and such here.
	public JSPCSRFTokenInjection(){ 
		logger = Logger.getLogger("csrfMitigationLogger"); 
		logger.info("CSRF Injection Aspect Created"); 
		watch = new StopWatch(); 
	} 
	
	//Capturing the CSRF Token from the request 
	//by intercepting the 
	//_jspService method inside of the JSP
	public pointcut csrf_jspServiceIntercept(HttpServletRequest req, 
		HttpServletResponse resp) : 
	    execution(* *._jspService(HttpServletRequest, 
	    		HttpServletResponse)) 
	    && args(req, resp);
	
	
	before(HttpServletRequest req, HttpServletResponse resp) : 
		csrf_jspServiceIntercept(req, resp){
		currentCSRFToken = (String) req.getAttribute("csrfSalt");
		logger.info("Got CSRF Token from request: " 
				+ currentCSRFToken);
	}
	
	//Pointcut and advice for capturing the writing into a JSP.
	public pointcut csrf_captureFormWriting(String msg) :
		call(public void JspWriter.write(String)) 
		&& args(msg) 
		&& if(msg.toLowerCase().contains("</form>"));

	Object around(String msg) : csrf_captureFormWriting(msg){
		
		msg = msg.replace("</form>", "<input type='hidden' " +
				"name='csrfSalt' value='" 
				+ currentCSRFToken + "'/></form>");
		logger.info("MSG Value: " + msg);
		return proceed(msg);
	}
} 
