package com.julian.sabos.bank.customer

import org.springframework.web.bind.annotation.*

@RestController
class CustomerController(private val repository: CustomerRepository) {

    @GetMapping("/customers")
    fun findAll() = repository.findAll()

    @GetMapping("/customers/{lastName}")
    fun findByLastName(@PathVariable lastName: String) = repository.findByLastName(lastName)


    @PostMapping("/customer", consumes = ["application/json"], produces = ["application/json"])
    fun createCustomer(@RequestBody customer: Customer) = repository.save(customer)
}