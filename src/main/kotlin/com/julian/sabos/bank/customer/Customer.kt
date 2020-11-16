package com.julian.sabos.bank.customer

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import com.julian.sabos.bank.account.Account
import javax.persistence.*

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
data class Customer(
        val lastName: String? = null,
        val firstName: String? = null,
        @JsonBackReference
        @ManyToMany(mappedBy = "accountOwners", fetch = FetchType.LAZY)
        val accounts: Set<Account>? = null,
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1,
) {
    override fun toString(): String {
        return "Customer(lastName=$lastName, firstName=$firstName, id=$id)"
    }
}