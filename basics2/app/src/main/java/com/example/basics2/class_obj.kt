package com.example.basics2

class MyClass {
    init {

    }

    fun showCount() {
        println("counter = " + counter)
    }
    companion object {
        var counter = 1

        fun counterUp() {
            counter += 1
        }


    }
}
class MyClass1 {
    companion object {
        const val propertyName: String = "Something..."
        fun funName() {
            // ...
        }
    }
}

fun main() {
   // println(MyClass.counter)
    var k = MyClass()
    MyClass.counterUp()
    k.showCount()



    val property = MyClass1.propertyName
    MyClass1.funName()
}