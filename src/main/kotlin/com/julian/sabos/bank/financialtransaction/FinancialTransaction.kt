package com.julian.sabos.bank.financialtransaction

import com.julian.sabos.bank.account.Account
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class FinancialTransaction(val name: String? = null,
                                val amount: Long? = null,
                                @ManyToOne(optional = false)
                                val accountFrom: Account? = null,
                                @ManyToOne
                                val accountTo: Account? = null,
                                val transactionTime: LocalDateTime? = null,
                                @Id @GeneratedValue
                                val id: Long = -1)