package com.example.basics2

fun main() {
    var b=0



    val lambda2: (String) -> Unit = { name: String -> println("My name is $name") }
    val sum1 : (Int)-> Unit = {num : Int -> println("$num") }
    sum1(3)
    lambda2("sanket")
    //val result = { println("Hello"); true }()
    val result = { val1: Int, val2: Int -> val1 * val2 }(10, 20)
    println(result)
    sum ({ println( k(it)) })

    val s =NewClassName();


}
fun sum (a:(Int)->Unit)
{
    val result = a(4)



}
fun k (a:Int):Int
{
   return a*10
}
fun buildMessageFor(name: String = "Customer", count: Int = 0): String {
    return("$name, you are customer number $count")
}
fun displayStrings(vararg strings: String)
{
    for (string in strings) {
        println(string)
    }
}
class NewClassName: ParentClass() {
   override fun p()
   {
       println("class current prperty")
   }


}

open class ParentClass {
    constructor()
    {

    }
    open fun p()
    {
        println("class property")
    }



}

