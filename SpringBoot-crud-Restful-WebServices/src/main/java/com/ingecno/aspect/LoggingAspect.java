package com.ingecno.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private static Logger logger = LogManager.getLogger(LoggingAspect.class);

	@Pointcut("execution(* com.ingecno.*.*.*(..))")
	private void generalPointcut() {

	}

	@Before("generalPointcut()") // before calling any method this will print log
	public void infoLog(JoinPoint joinPoint) {
		logger.info(joinPoint.getTarget().getClass().getSimpleName() + " : " + joinPoint.getSignature().getName());

	}

	//whenever any exception this will print exception message
	@AfterThrowing(pointcut = "generalPointcut() throws exception ", throwing = "exception")
	public void exceptionLog(JoinPoint joinPoint, Exception exception) throws Exception {
		logger.error(joinPoint.getTarget().getClass().getSimpleName() + " : " + joinPoint.getSignature().getName()
				+ ": " + exception.getMessage());

	}

}