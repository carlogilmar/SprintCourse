package com.makingdevs.business

import com.makingdevs.aspects.AspectsConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import java.lang.Void as Should

/**
 * Created by carlosins on 26/11/16.
 */
@ContextConfiguration(classes=[BusinessConfig, AspectsConfig])
class MyMathSpec extends Specification{

    @Autowired
    MyMath myMath

    Should "get the prime numbers until"(){
        given:"A number"
        Integer i=10
        when:"search a sequence of primes"
        def sequence = myMath.primesTo(i)
        then:"get the sequence"
        sequence==[2,3,5,7]
    }

}
