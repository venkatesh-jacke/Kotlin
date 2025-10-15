package coroutine

import kotlinx.coroutines.*

fun main(){
    runBlocking {
        println("Main thread is blocked")
        launch {
            delay(1000L)
            println("Coroutine from runBlocking")
        }
        coroutineScope {
            launch {
                delay(500L)
                println("Coroutine from coroutineScope")
            }
        }
        GlobalScope.launch {
            delay(2500L)
            println("Coroutine from GlobalScope")
        }
        delay(3000L)
    }
    println("Main thread is free")
}

/*

 */