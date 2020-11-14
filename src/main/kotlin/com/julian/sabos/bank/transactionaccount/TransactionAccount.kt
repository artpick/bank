package com.julian.sabos.bank.transactionaccount

import com.julian.sabos.bank.account.Account
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class TransactionAccount(val amount: Long,
                              val name: String,
                              val accountFrom: Account,
                              val accountTo: Account,
                              @Id @GeneratedValue
                              val id: Long = -1)