package com.julian.sabos.bank.customer

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class CustomerRepositoryTest(@Autowired private val entityManager: TestEntityManager,
                             @Autowired private val customerRepo: CustomerRepository) {

    @Test
    fun `should create a dumb customer, no relations`() {
        // GIVEN
        val customer = Customer("Marple", "Jane")

        // WHEN
        entityManager.persist(customer)
        val customersFound: Iterable<Customer> = customerRepo.findAll()

        // THEN
        Assertions.assertThat(customersFound).hasSize(4)
                .anyMatch { currentCustomer -> currentCustomer.firstName == "Jane" && currentCustomer.lastName == "Marple" }
    }
}