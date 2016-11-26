package com.makingdevs.aspects

import groovy.util.logging.Slf4j
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

/**
 * Created by carlosins on 26/11/16.
 */
@Component
@Aspect
@Slf4j
class BeforeAdvice {

    @Before("execution(* com.makingdevs.business..*(..))")
    void before(JoinPoint jp){
        log.debug "-----| 1.- Before  ${jp.signature.name} (${jp.args})|-------"
    }

    @After("execution(* com.makingdevs.business..*(..))")
    void after(JoinPoint jp){
        log.debug "-----|| 2.-  After  ${jp.signature.name} (${jp.args})      ||----"
    }

    @AfterReturning("execution(* com.makingdevs.business..*(..))")
    void afterReturning(JoinPoint jp){
        log.debug "---|| 3.- After Returning  ${jp.signature.name} (${jp.args}) ||----"
    }

    @Around("execution(* com.makingdevs.business..*(..))")
    def around(ProceedingJoinPoint pjp){
        log.debug "----|| 4.-         AroundBefore  ${pjp.signature.name} (${pjp.args})      ||-----"
        def val=pjp.proceed()
        log.debug "----|| 5.-         AroundAfter  ${pjp.signature.name} (${pjp.args})      ||-----"
        val
    }

}
