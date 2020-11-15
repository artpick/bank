package com.julian.sabos.bank.account

import com.julian.sabos.bank.customer.Customer
import com.julian.sabos.bank.financialtransaction.FinancialTransaction
import javax.persistence.*

//TODO: add currency attribute
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
open class Account constructor(
        @Id
        open val IBAN: String? = null,
        open val balance: Long? = null,
        // Target PERSIST and MERGE only to avoid DELETE cascade and delete all
        @ManyToMany(cascade = [
            CascadeType.PERSIST,
            CascadeType.MERGE
        ])
        // Map the join table
        @JoinTable(name = "account_owner",
                joinColumns = [JoinColumn(name = "account_id")],
                inverseJoinColumns = [JoinColumn(name = "owner_id")]
        )
        open val accountOwners: Set<Customer>? = null,
        @OneToMany(mappedBy = "accountFrom")
        open val incomingOperations: List<FinancialTransaction>? = null,
        @OneToMany(mappedBy = "accountTo")
        open val outgoingOperations: List<FinancialTransaction>? = null) {

    override fun toString(): String {
        return "Account(IBAN=$IBAN, balance=$balance)"
    }
}
