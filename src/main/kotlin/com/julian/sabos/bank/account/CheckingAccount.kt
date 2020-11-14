package com.julian.sabos.bank.account

import com.julian.sabos.bank.customer.Customer
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class CheckingAccount(@Id val IBAN: String,
                           val RIB: String,
                           @OneToMany
                           override val customer: Set<Customer>) : Account