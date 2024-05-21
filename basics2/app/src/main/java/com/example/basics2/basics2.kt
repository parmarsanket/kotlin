package com.example.basics2

import android.provider.SyncStateContract.Columns

fun main() {

// makeCoffee(1,"Sanket")
 //makeCoffee(4,"shernik")

   // var a:Int= readln().toInt()
   // var b:Int= readln().toInt()

 //println(add(a,b))
   // println(div(a,b))

    //creating object of class

    var doggy= dog("doy")
    var cutty=cat()
    val name1:String

    name1="sanket"
    println(name1)

    println("the dog name is ${doggy.name}")


}
fun div (a:Int ,b:Int):Double
{
    val r=a/b.toDouble()
    return r
}
fun add (a:Int,b:Int):Int
{
    return a+b
}
fun makeCoffee(surerCount : Int, Name : String)
{
    if (surerCount==1)
        println("Coffee with $surerCount spoon of Surer")
    else
        println("Coffee with $surerCount spoons of Surer")

}
class cat
{
    init {
        println(
            "hello citti"
        )
    }

}
