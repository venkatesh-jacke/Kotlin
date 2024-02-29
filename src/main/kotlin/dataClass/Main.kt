package dataClass

fun main(){

    val venkat= Person("Venkat",23)
    val jacke=Person("Venkat",23)
    val ram= Person("Ram",23)

    //The below two lines gives you a sample result since, hashcode are same for both the objects
    //It;s getting checked with the contents where they are same in this case
    //In kotlin data class checks with the content and say it as same object but in java it will return a two different objects compared to normal class
    println(venkat.hashCode())
    println(jacke.hashCode())

    println(ram.hashCode())


    //In java it will return a memory address of the object
    //In Kotlin iot return the content
    println(venkat.toString())
    println(ram.toString())


}

data class Person(val name:String,val age:Int)