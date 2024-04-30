package com.example.bankaccountprogram

fun main() {
    val sanketBankAccount =BackAccount("sanket",1200.94)
    println(sanketBankAccount.accountHolder)

    sanketBankAccount.deposit(100.45)
    sanketBankAccount.withdraw(23.08)
    sanketBankAccount.deposit(235.42)
    sanketBankAccount.deposit(234.3)
    sanketBankAccount.displayTransactionHistory()
}