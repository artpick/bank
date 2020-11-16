package com.julian.sabos.bank.financialtransaction

import com.julian.sabos.bank.account.CheckingAccount
import com.julian.sabos.bank.account.FAKE_IBAN
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import java.time.LocalDateTime

const val NAME_TRANSACTION: String = "SALARY OCT 2020"

@DataJpaTest
class FinancialTransactionRepositoryTest(@Autowired private val entityManager: TestEntityManager,
                                         @Autowired private val financialTransactionRepo: FinancialTransactionRepository) {

    @Test
    fun `should create a dumb financial transaction, a checking account`() {
        // GIVEN
        val newCheckingAccount = CheckingAccount(FAKE_IBAN, 100)
        entityManager.persist(newCheckingAccount)
        val financialTransaction = FinancialTransaction(NAME_TRANSACTION, 1000, newCheckingAccount)

        // WHEN
        entityManager.persist(financialTransaction)
        val financialTransactionFound: Iterable<FinancialTransaction> = financialTransactionRepo.findAll()

        // THEN
        Assertions.assertThat(financialTransactionFound).hasSize(1)
                .anyMatch { currentFinancialTransaction -> currentFinancialTransaction.name == NAME_TRANSACTION }
    }


    @Test
    fun `should create a dumb financial transaction, with current date as transaction time`() {
        // GIVEN
        val newCheckingAccount = CheckingAccount(FAKE_IBAN, 100)
        entityManager.persist(newCheckingAccount)
        val financialTransaction = FinancialTransaction(NAME_TRANSACTION, 1000, newCheckingAccount, null, LocalDateTime.now())

        // WHEN
        entityManager.persist(financialTransaction)
        val financialTransactionFound: Iterable<FinancialTransaction> = financialTransactionRepo.findAll()

        // THEN
        Assertions.assertThat(financialTransactionFound).hasSize(1)
                .anyMatch { currentFinancialTransaction -> currentFinancialTransaction.name == NAME_TRANSACTION }
    }
}