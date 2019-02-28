package com.github.andrewgazelka.eulerproject.test

import com.github.andrewgazelka.eulerproject.problems.FactorResult
import com.github.andrewgazelka.eulerproject.util.distinctLoop
import com.github.andrewgazelka.eulerproject.util.generateTest
import com.github.andrewgazelka.eulerproject.util.productSumFactors
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class UtilsTest {

    @Test
    fun `distinct test`(){
//        generateTest(false)
        distinctLoop(3, 1..3){

        }
    }


    @Test
    fun `product sum`(){
        for (productSumFactor in productSumFactors(12)) {
//            setOf(
//                FactorResult(1, 1), // 1 = 1
//                FactorResult(1, 2), // 2 = 2
//                FactorResult(1, 3), // 3 = 3
//                FactorResult(1 , 4), // 4 = 4
//                FactorResult(2, 2) // 4 ... 2 + 2 = 2*2
//            )


            println(productSumFactor)
        }
    }
}
