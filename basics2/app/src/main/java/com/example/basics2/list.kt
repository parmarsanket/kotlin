package com.example.basics2

fun main() {
    val list1= listOf(1,2,3,4,5,6)
    val list2= mutableListOf<Int>(1,2,3,5,5,6,7)

    list2.add(1,3)
    list2.removeAt(0)
    list2.remove(3)
    list2.remove(3)


    println(list2)
}