package com.julian.sabos.bank.account

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

const val FAKE_IBAN = "FR7630001007941234567890185"

@DataJpaTest
class CheckingAccountRepositoryTest(@Autowired private val entityManager: TestEntityManager,
                                    @Autowired private val checkingAccountRepo: CheckingAccountRepository) {


    @Test
    fun `should create a dumb checking account, no relations`() {
        // GIVEN
        val newCheckingAccount = CheckingAccount(FAKE_IBAN, 100)

        // WHEN
        entityManager.persist(newCheckingAccount)
        val checkingAccountsFound: Iterable<CheckingAccount> = this.checkingAccountRepo.findAll()

        // THEN
        Assertions.assertThat(checkingAccountsFound).hasSize(4).anyMatch { currentCheckingAccount ->
            currentCheckingAccount.IBAN == FAKE_IBAN
        }
    }
}

