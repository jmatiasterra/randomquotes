/**
 * 
 */
package com.assessment.randomquotes.resource.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author matias.terracciano
 *
 */
@Aspect
@Component
public class TimeSpentAspect {

	private static final Logger logger = LoggerFactory.getLogger(TimeSpentAspect.class);

	@Around("execution(* com.assessment.randomquotes.resource.services.*.*(..))")
	public Object logTimeSpent(ProceedingJoinPoint jointPoint) throws Throwable {

		Long startTime = System.currentTimeMillis();
		Object retval = jointPoint.proceed();
		Long endTime = System.currentTimeMillis();
		Long timeSpent = endTime - startTime;

		logger.info("The time spent of the service " + jointPoint.getSignature().getName() +" is "+ timeSpent);

		return retval;

	}

}
