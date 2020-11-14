package com.example.mvc.controller.get

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "30000")
class GetApiControllerTest {

    @LocalServerPort
    private var port: Int = 0;

    @Autowired
    lateinit var webTestClient: WebTestClient

    // equivalent of final static
    companion object {
        private const val REQUEST_MAPPING: String = "/api/"
        private const val LOCALHOST: String = "http://localhost:";
    }

    @Test
    fun get() {

        // given
        val requestUrl: String = LOCALHOST + port + REQUEST_MAPPING + "hello"

        // when
        webTestClient.get()
                .uri(requestUrl)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .consumeWith {
                    assertThat(it.responseBody?.let { it1 -> String(it1) }).isEqualTo("hello kotlin")
                }
    }

}