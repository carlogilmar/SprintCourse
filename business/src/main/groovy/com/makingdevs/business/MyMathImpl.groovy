package com.makingdevs.business

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

/**
 * Created by carlosins on 26/11/16.
 */
@Service
@Slf4j
class MyMathImpl implements com.makingdevs.business.MyMath {
    @Override
    List<Integer> primesTo(int i) {
        log.info "${MyMathImpl.class.name} -Primes to!"
        [2,3,5,7]
    }
}
