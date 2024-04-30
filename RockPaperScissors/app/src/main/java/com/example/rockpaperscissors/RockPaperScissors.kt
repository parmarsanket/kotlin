package com.example.rockpaperscissors

fun main() {
    println("hello gamers ")

    var computerchoice =""
    var playerchoice =""

    println("enter rock  paper scissors?! , your choice")
    playerchoice = readln()
    while (!(playerchoice=="rock"||playerchoice=="paper"||playerchoice=="scissors"))
    {
        println("enter valid input")
        playerchoice= readln()
    }
    var randomchoice=(1..3).random()

    when (randomchoice)
    {
        1->{
        computerchoice = "rock"
             }
        2->  {
        computerchoice = "paper"

    } 3-> {
        computerchoice = "scissors"
    }
    }
    println(computerchoice)
   var winner=when{
       computerchoice==playerchoice ->"Tie"
       playerchoice == "rock" &&computerchoice =="scissors"->"player"
       playerchoice == "paper" &&computerchoice =="rock"->"player"
       playerchoice == "scissors" &&computerchoice =="paper"->"player"
       else ->"computer"

   }
    if (winner == "Tie")
    {
        println("result is tie")
    }
    else {
        println("the game result is $winner won")
    }
}
