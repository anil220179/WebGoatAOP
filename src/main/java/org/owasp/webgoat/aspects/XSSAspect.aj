package org.owasp.webgoat.aspects;

import com.thesis.aop.util.ThesisUtil;
import com.thesis.aop.util.StopWatch;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.util.HashMap;
import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;
import net.sf.jsqlparser.JSQLParserException;

public aspect XSSAspect {
	public HashMap<String, String> fixes = new HashMap<String, String>();
	public HashMap<String, String> customRegex = new HashMap<String, String>();
	Logger logger;
	StopWatch watch;

	public XSSAspect() {
		//PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger("xssLogger");
		logger.info("XSS Aspect Created!");
		watch = new StopWatch();

		fixes.put("UpdateProfile.java_122", "JAVASCRIPT-ENCODING");
		fixes.put("UpdateProfile.java_123", "JAVASCRIPT-ENCODING");
		fixes.put("UpdateProfile.java_117", "JAVASCRIPT-ENCODING");
		fixes.put("UpdateProfile.java_118", "JAVASCRIPT-ENCODING");

	}
	
	pointcut xss_writeFunction(String param1) : 
		call(* *.write(String)) && 
		within(*..UpdateProfile) && 
		args(param1);
		
	Object around(String param1) : xss_writeFunction(param1){
		watch.start();
		if(fixes.containsKey(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine())){
			
			try{
				String result = ThesisUtil.doXSSFix(param1, fixes.get(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
					thisJoinPoint.getSourceLocation().getLine()));
				proceed(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else{
			proceed(param1);
		}
		watch.stop();
		logger.info(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine() + "," + watch.getElapsedTime());			
					
		return null;
	}

	pointcut xss_writeByteArrayFunction(byte[] param1) : 
		call(* *.write(byte[])) && 
		within(*..UpdateProfile) && 
		args(param1);
		
	Object around(byte[] param1) : xss_writeByteArrayFunction(param1){
		watch.start();
		if(fixes.containsKey(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine())){
			
			try{
				byte[] result = ThesisUtil.doXSSFix(param1, fixes.get(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
					thisJoinPoint.getSourceLocation().getLine()));
				proceed(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else{
			proceed(param1);
		}
		watch.stop();
		logger.info(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine() + "," + watch.getElapsedTime());			
					
		return null;
	}

	pointcut xss_printFunction(String param1) : 
		call(* *.print(String)) && 
		within(*..UpdateProfile) && 
		args(param1);
		
	Object around(String param1) : xss_printFunction(param1){
		watch.start();
		if(fixes.containsKey(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine())){
			
			try{
				String result = ThesisUtil.doXSSFix(param1, fixes.get(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
					thisJoinPoint.getSourceLocation().getLine()));
				proceed(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else{
			proceed(param1);
		}
		watch.stop();
		logger.info(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine() + "," + watch.getElapsedTime());			
					
		return null;
	}

	pointcut xss_printlnFunction(String param1) : 
		call(* *.println(String)) && 
		within(*..UpdateProfile) && 
		args(param1);
		
	Object around(String param1) : xss_printlnFunction(param1){
		watch.start();
		if(fixes.containsKey(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine())){
			
			try{
				String result = ThesisUtil.doXSSFix(param1, fixes.get(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
					thisJoinPoint.getSourceLocation().getLine()));
				proceed(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else{
			proceed(param1);
		}
		watch.stop();
		logger.info(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine() + "," + watch.getElapsedTime());			
					
		return null;
	}

	pointcut xss_sendErrorFunction(String param1) : 
		call(* *.sendError(String)) && 
		within(*..UpdateProfile) && 
		args(param1);
		
	Object around(String param1) : xss_sendErrorFunction(param1){
		watch.start();
		if(fixes.containsKey(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine())){
			
			try{
				String result = ThesisUtil.doXSSFix(param1, fixes.get(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
					thisJoinPoint.getSourceLocation().getLine()));
				proceed(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else{
			proceed(param1);
		}
		watch.stop();
		logger.info(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine() + "," + watch.getElapsedTime());			
					
		return null;
	}

	pointcut xss_getParameterFunction(String param1) : 
		call(* *.getParameter(String)) && 
		within(*..UpdateProfile) && 
		args(param1);
		
	Object around(String param1) : xss_getParameterFunction(param1){
		watch.start();
		if(fixes.containsKey(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine())){
			
			try{
				String result = (String) proceed(param1);
				
				String encodedValue = ThesisUtil.doXSSFix(result, fixes.get(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
					thisJoinPoint.getSourceLocation().getLine()));
			
			    return encodedValue;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else{
			return proceed(param1);
		}
		watch.stop();
		logger.info(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine() + "," + watch.getElapsedTime());			
					
		return proceed(param1);
	}

	pointcut xss_setAttributeFunction(String param1) : 
		call(* *.setAttribute(String)) && 
		within(*..UpdateProfile) && 
		args(param1);
		
	Object around(String param1) : xss_setAttributeFunction(param1){
		watch.start();
		if(fixes.containsKey(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine())){
			
			try{
				String result = ThesisUtil.doXSSFix(param1, fixes.get(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
					thisJoinPoint.getSourceLocation().getLine()));
				proceed(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else{
			proceed(param1);
		}
		watch.stop();
		logger.info(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine() + "," + watch.getElapsedTime());			
					
		return null;
	}

	pointcut xss_writeByteArrayThreeParam(byte[] param1, String param2, String param3) : 
		call(* *.write(byte[], String, String)) && 
		within(*..UpdateProfile) && 
		args(param1, param2, param3);
		
	Object around(byte[] param1, String param2, String param3) : xss_writeByteArrayThreeParam(param1, param2, param3){
		watch.start();
		if(fixes.containsKey(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine())){
			
			try{
				byte[] result = ThesisUtil.doXSSFix(param1, fixes.get(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
					thisJoinPoint.getSourceLocation().getLine()));
				proceed(result, param2, param3);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else{
			proceed(param1, param2, param3);
		}
		watch.stop();
		logger.info(thisJoinPoint.getSourceLocation().getFileName() + "_" + 
			thisJoinPoint.getSourceLocation().getLine() + "," + watch.getElapsedTime());			
					
		return null;
	}
	
	
}
