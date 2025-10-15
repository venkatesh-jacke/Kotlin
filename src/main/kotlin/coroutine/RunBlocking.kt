package coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    println("Before runBocking")
    runBlocking {
        launch(Dispatchers.IO) {
            delay(3000)
            println("Finished Io Coroutine-1")
        }
        launch(Dispatchers.IO) {
            delay(3000)
            println("Finished Io Coroutine-2")
        }
        println("Started runBocking")
        delay(3000)
        println("End runBocking")
    }
    println("After runBocking")
}

/*
Output
Before runBocking
Started runBocking
End runBocking
Finished Io Coroutine-1
Finished Io Coroutine-2
After runBocking

Explanation:

✅ runBlocking will **pause the main thread** and wait for all coroutines launched within it to complete.

✅ The two IO coroutines are launched **asynchronously**, but the main thread **waits for them** to finish because they're inside `runBlocking`.

✅ Two coroutines are launched on IO dispatcher. They run in the background and are not waited for unless you use join().

✅ The `delay(3000)` inside `runBlocking` will block for 3 seconds, during which time the two IO coroutines also start and delay for 3 seconds concurrently.

✅ Since all delays are for 3 seconds, total run time is just **around 3 seconds**, not 9.


✅ Only after everything inside `runBlocking` is done, `println("After runBocking")` gets printed.
*/