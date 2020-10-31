package com.blopesdeveloper.application.integration

import com.blopesdeveloper.application.entrypoint.OrderController
import com.blopesdeveloper.application.gateway.OrderGateway
import com.blopesdeveloper.domain.entity.Order
import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.common.http.TestHTTPEndpoint
import io.quarkus.test.h2.H2DatabaseTestResource
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test
import javax.inject.Inject

@QuarkusTest
@TestHTTPEndpoint(OrderController::class)
@QuarkusTestResource(H2DatabaseTestResource::class)
class OrderControllerIntegrationTest {

    @Inject
    lateinit var orderGateway: OrderGateway

    @Test
    fun `given a saved order when call findAll should return the orders`() {
        orderGateway.save(
            Order(
                id = null,
                userId = "1010"
            )
        )

        given()
            .`when`().get()
            .then()
            .statusCode(200)

    }

}