package coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        getFollowers_parallel()
    }
}

//Runs in Parallel
suspend fun getFollowers_parallel() = coroutineScope {
    val time = measureTimeMillis {
        val fb = async { getFbFollowers() }
        val insta = async { getInstaFollowers() }

        println("Fb ${fb.await()} insta ${insta.await()}")
    }
    println("Time taken is $time ms") //2sec
}
/*
async { getFbFollowers() } and async { getInstaFollowers() } start in parallel.
 */

//Runs in Sequential
suspend fun getFollowers_sequential() {
    val time = measureTimeMillis {
        val fbFollowers = coroutineScope { async { getFbFollowers() } }
        val instaFollowers = coroutineScope { async { getInstaFollowers() } }

        println("Fb ${fbFollowers.await()} insta ${instaFollowers.await()}")
    }
    println("Time taken is $time ms") //4sec
}

/*
You wrap each async inside its own coroutineScope {} block.
 */
suspend fun getFbFollowers(): Int {
    delay(2000L)
    return 24
}

suspend fun getInstaFollowers(): Int {
    delay(2000L)
    return 424
}
/*
Each coroutineScope { async { ... } } starts and waits inside the scope before moving to the next one — effectively serial execution.
 */
/*
 Rule of Thumb:
✅ async {} inside the same coroutine scope = runs in parallel

❌ Wrapping each async {} in separate coroutineScope {} = runs sequentially (nested + suspended)
 */