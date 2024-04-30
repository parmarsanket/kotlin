package com.example.bankaccountprogram

class BackAccount( var accountHolder:String, var balance:Double) {
    private  val transactionHistory = mutableListOf<String>()
    fun deposit(amount : Double)
    {
        balance+=amount.toFloat()
        transactionHistory.add("$accountHolder deposit ${amount.toFloat()} , total balance is ${balance.toFloat()} ")

    }
    fun withdraw(amount: Double)
    {
        if(amount>balance)
        {
            //we cant withdrew amount
            println("you don't have the funds to withdraw $amount")

        }
        else
        {
            balance-=amount.toFloat()
            transactionHistory.add("$accountHolder withdrew ${amount.toFloat()} , total balance is ${balance.toFloat()} ")

        }

    }
    fun displayTransactionHistory()
    {
        println("account holder: $accountHolder transaction history")

        for ( transaction in transactionHistory)
        {
            println(transaction)
        }

    }
}