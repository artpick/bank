package com.julian.sabos.bank.financialtransaction

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FinancialTransactionRepository : JpaRepository<FinancialTransaction, Long>