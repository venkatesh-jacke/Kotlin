package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.Job

fun main() {
    // ✅ Use runBlocking to block main thread until coroutine finishes
    runBlocking {
        // Launch a coroutine in GlobalScope and keep a reference to it
        val job: Job = GlobalScope.launch {
            delay(1000)
            println("hi") // Will be printed after 1 second
        }

        job.join() // 👈 Waits for coroutine to finish before moving on
    }

    println("Main") // Will be printed AFTER "hi"
}


/*
🧠 Explanation:

❌ GlobalScope.launch {} does NOT wait!
It starts a fire-and-forget coroutine — like saying:
“Hey! Start this task somewhere, I won’t wait for you.”

✅ runBlocking waits for everything inside it to complete.

💡 If you really want to wait for that task to finish, you have to:
1. Store the coroutine in a variable (Job)
2. Call job.join() to wait for it

🧪 Output:
hi
Main

This is because we wait for `hi` to print before continuing to `Main`.
*/
