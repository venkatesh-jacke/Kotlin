package coroutine

import kotlinx.coroutines.*

fun main(){
  runBlocking {
      launch {
          task1()
      }
      launch {
          task2()
      }
  }
}
suspend fun task1(){
    println("Start Task-1")
    delay(2000L)
    println("End Task-1")
}

suspend fun task2(){
    println("Start Task-2")
    delay(2000L)
    println("End Task-2")
}

/*
Output
Start Task-1
Start Task-2
End Task-1
End Task-2

 * Simulates a suspending task by delaying for 2 seconds.
 * This coroutine prints a message before and after the delay
 * to demonstrate asynchronous behavior.
 */