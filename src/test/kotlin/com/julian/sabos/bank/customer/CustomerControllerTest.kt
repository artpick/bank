package com.julian.sabos.bank.customer

import org.assertj.core.api.Assertions.assertThat
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
class CustomerControllerTest(@Autowired private val restTemplate: TestRestTemplate) {

    @Test
    fun `find all customers`() {
        val content = """[{"id":1,"lastName":"Sabos","firstName":"Julian"},{"id":2,"lastName":"Melrose","firstName":"Place"},{"id":3,"lastName":"Valjean","firstName":"Jean"},{"id":4,"lastName":"Fonda","firstName":"Jane"}]"""
        // WHEN
        val result: ResponseEntity<String> = restTemplate.getForEntity("/customers", String::class.java)

        // THEN
        assertThat(result.body).isEqualTo(content)
    }


    @Test
    fun `create a customer`() {
        val customer = Customer("Fonda", "Jane")
        val headers = HttpHeaders()
        val request: HttpEntity<Customer> = HttpEntity<Customer>(customer, headers)
        val content = """{"id":4,"lastName":"Fonda","firstName":"Jane"}"""
        // WHEN
        val result: ResponseEntity<String> = restTemplate.postForEntity("/customer", request, String::class.java)

        // THEN
        assertThat(result.body).isEqualTo(content)
    }
}