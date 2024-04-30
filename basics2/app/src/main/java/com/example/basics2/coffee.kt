package com.example.basics2

data class coffeedetails(var name:String , val size:Int)

fun main() {

   val sanket = coffeedetails("sanket",2)
    val obj = makecoffee(sanket)


    obj.k.name="vinay"
    obj.making()






}



class makecoffee(val k:coffeedetails)
{
    init {
        making()
    }
    fun  making()
    {
        println(k.name)
        println(k.size)
    }

}