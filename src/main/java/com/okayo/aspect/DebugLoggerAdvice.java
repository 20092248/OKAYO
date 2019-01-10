package com.okayo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DebugLoggerAdvice {
	Logger logger = Logger.getLogger("AOP");
	
	@Before("execution(* com.okayo.service..*.*(..))")
	public void beforeService(JoinPoint joinPoint) {
		logger.info("<<<<<<SERVICE>>>>>>>> : " + joinPoint.getSignature().getName());
	}
	
	@Before("execution(* com.okayo.dao..*.*(..))")
	public void beforeDao(JoinPoint joinPoint) {
		logger.info("<<<<<<DAO>>>>>>>> : " + joinPoint.getSignature().getName());
	}

}