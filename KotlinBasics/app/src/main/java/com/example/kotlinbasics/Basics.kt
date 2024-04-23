package com.example.kotlinbasics

fun main()
{
    val a:UByte=10u

    val my1 = true;
    val char:Char ='\u00AE'
    val mt2 = false;
    val string:String = "Sanket"

    val k= readln().toInt()
//comment
    println((my1&&mt2))
    println((my1||mt2))
    println(!my1)
    println(char)
    println(string.uppercase())

    if(k in 18..40)
    {
        println("your are older")
    }
    else
    {
        println("you are younger")
    }




}