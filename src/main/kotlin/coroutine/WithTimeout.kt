package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main()= runBlocking {
    try {
        withTimeout(3000L){
            repeat(10){i->
                println("Processing $i")
                delay(1000L)
            }
        }
    }
    catch (e:Exception){
        println(e.message)
    }
}