package com.julian.sabos.bank.account

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CheckingAccountRepository : JpaRepository<CheckingAccount, String> {

    fun findByIBAN(IBAN: String): List<CheckingAccount>
}