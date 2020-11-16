package com.julian.sabos.bank.account

import org.springframework.web.bind.annotation.*

@RestController
class CheckingAccountController(private val repository: CheckingAccountRepository) {

    @GetMapping("/checkingaccounts")
    fun findAll() = repository.findAll()

    @GetMapping("/checkingaccounts/{IBAN}")
    fun findIBAN(@PathVariable IBAN: String) = repository.findByIBAN(IBAN)

    @PostMapping("/checkingaccount", consumes = ["application/json"], produces = ["application/json"])
    fun createCustomer(@RequestBody checkingAccount: CheckingAccount) = repository.save(checkingAccount)
}