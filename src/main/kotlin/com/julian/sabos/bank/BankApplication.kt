package com.julian.sabos.bank

import com.julian.sabos.bank.account.CheckingAccount
import com.julian.sabos.bank.account.CheckingAccountRepository
import com.julian.sabos.bank.customer.Customer
import com.julian.sabos.bank.customer.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BankApplication {
    private val log = LoggerFactory.getLogger(BankApplication::class.java)

    @Bean
    fun init(customerRepository: CustomerRepository, checkingAccountRepository: CheckingAccountRepository) = CommandLineRunner {
        val jsa = Customer("Sabos", "Julian")
        checkingAccountRepository.save(CheckingAccount("FR7630004000031234567890143", 1000, hashSetOf(jsa)))

        val mplace = Customer("Melrose", "Place")
        checkingAccountRepository.save(CheckingAccount("FR7630006000011234567890189", 1200, hashSetOf(mplace)))

        val jval = Customer("Valjean", "Jean")
        checkingAccountRepository.save(CheckingAccount("FR7610107001011234567890129", 3000, hashSetOf(jval)))

        // fetch all customers
        log.info("Customers found with findAll():")
        log.info("-------------------------------")
        customerRepository.findAll().forEach { log.info(it.toString()) }
        log.info("")

        log.info("CheckingAccounts found with findAll():")
        log.info("-------------------------------")
        checkingAccountRepository.findAll().forEach { log.info(it.toString()) }
        log.info("")

        // fetch customers by last name
        log.info("Customer found with findByLastName('Valjean'):")
        log.info("--------------------------------------------")
        customerRepository.findByLastName("Valjean").forEach { log.info(it.toString()) }
        log.info("")
    }

}

fun main(args: Array<String>) {
    runApplication<BankApplication>(*args)
}
