package com.julian.sabos.bank.account

import com.julian.sabos.bank.customer.Customer
import com.julian.sabos.bank.financialtransaction.FinancialTransaction
import javax.persistence.Entity

@Entity
class CheckingAccount(
        IBAN: String? = null,
        balance: Long? = null,
        accountOwners: Set<Customer>? = null,
        incomingOperations: List<FinancialTransaction>? = null,
        outgoingOperations: List<FinancialTransaction>? = null
) : Account(IBAN, balance, accountOwners, incomingOperations, outgoingOperations){

}