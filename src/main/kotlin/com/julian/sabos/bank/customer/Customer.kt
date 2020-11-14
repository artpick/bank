package com.julian.sabos.bank.customer

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Customer(@Id @GeneratedValue
                    val id: Long = -1,
                    val name: String,
                    val firstName: String
)