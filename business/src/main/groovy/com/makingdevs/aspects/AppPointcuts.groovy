package com.makingdevs.aspects

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component

/**
 * Created by carlosins on 2/12/16.
 */
@Component
@Aspect
class AppPointcuts {
    @Pointcut("execution(* com.makingdevs.business..*(..)) && !execution(* *.getMetaClass(..))")
    void pointcutBusinessApp(){

    }
}
