package inline

fun main() {
    home()
}

fun home() {
    println("Room")
    kitchen {
        println("cooking")
    }
    println("staircase")

}

inline fun kitchen(noinline cook: () -> Unit) {
    cook()
    println("Kitchen")
}

/*
inline function
1.When a function is marked with inline than the compiler will copy the function into call site in runtime,
compiler will not create a instance for that function

inline with higher order function
2.inlining the function that contains lambda(high-order function) is also inline the lambda itself and prevents the object creation

Compiled Version
fun home(){
    print("Room")
    println("cooking")
    println("Kitchen")
    print("staircase")
}

inline with return
3.if we return from the lambda it will treat as local return and compiler will discard the code after it

output
Room
cooking
/staircase is not executed


crossinline
4.if we want to restrict no one can return from the lambda  we can mark the function type parameter as crossinline.

noinline
5.we mark function as noinlinbe so that compiler will not optmize the code for it also we cant use return in it.

Compiled Version
fun home(){
    print("Room")
    fun cook(){
       println("cooking")
    }
    println("Kitchen")
    print("staircase")
}




*/
