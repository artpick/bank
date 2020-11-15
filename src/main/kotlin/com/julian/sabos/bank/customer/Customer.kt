package com.julian.sabos.bank.customer

import com.julian.sabos.bank.account.Account
import javax.persistence.*

@Entity
data class Customer(
        val name: String? = null,
        val firstName: String? = null,
        @ManyToMany(mappedBy = "accountOwners")
        val accounts: Set<Account> = HashSet(),
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1,
)