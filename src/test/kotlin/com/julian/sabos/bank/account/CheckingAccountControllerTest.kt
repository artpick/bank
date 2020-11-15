package com.julian.sabos.bank.account

import com.julian.sabos.bank.customer.Customer
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding
import org.assertj.core.api.Assertions
import org.junit.Ignore
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CheckingAccountControllerTest(@Autowired private val restTemplate: TestRestTemplate) {

    @Test
    fun `find all checking accounts`() {
        //
        val content = """[{"balance":1000,"accountOwners":[{"id":1,"lastName":"Sabos","firstName":"Julian"}],"incomingOperations":[],"outgoingOperations":[],"iban":"FR7630004000031234567890143"},{"balance":1200,"accountOwners":[{"id":2,"lastName":"Melrose","firstName":"Place"}],"incomingOperations":[],"outgoingOperations":[],"iban":"FR7630006000011234567890189"},{"balance":3000,"accountOwners":[{"id":3,"lastName":"Valjean","firstName":"Jean"}],"incomingOperations":[],"outgoingOperations":[],"iban":"FR7610107001011234567890129"}]"""
        // WHEN
        val result: ResponseEntity<String> = restTemplate.getForEntity("/checkingaccounts", String::class.java)

        // THEN
        Assertions.assertThat(result.body).isEqualTo(content)
    }


    /*
    //TODO: To be tested
    @Test
    fun `create a checking account`() {
        //
        val youss = Customer("Youssoufa", "")
        val checkingAccount = CheckingAccount("FR123", 90, hashSetOf(youss))
        val headers = HttpHeaders()
        val request: HttpEntity<CheckingAccount> = HttpEntity<CheckingAccount>(checkingAccount, headers)
        val content = ""
        // WHEN
        val result: ResponseEntity<String> = restTemplate.postForEntity("/checkingaccount", request, String::class.java)

        // THEN
        Assertions.assertThat(result.body).isEqualTo(content)
    }

    @Test
    fun `find checking account by IBAN`() {
        //
        val content = ""
        // WHEN
        val result: ResponseEntity<String> = restTemplate.getForEntity("/checkingaccount/FR7630004000031234567890143", String::class.java)

        // THEN
        Assertions.assertThat(result.body).isEqualTo(content)
    }

     */
}