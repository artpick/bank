package com.julian.sabos.bank.account

import com.julian.sabos.bank.customer.Customer

interface Account {
    val customer: Set<Customer>
}