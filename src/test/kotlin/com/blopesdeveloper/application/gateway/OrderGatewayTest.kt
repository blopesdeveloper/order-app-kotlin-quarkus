package com.blopesdeveloper.application.gateway

import com.blopesdeveloper.application.gateway.entity.OrderDB
import com.blopesdeveloper.application.gateway.mapper.OrderDBMapper
import com.blopesdeveloper.domain.entity.Order
import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.junit.mockito.InjectMock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import javax.inject.Inject

@QuarkusTest
class OrderGatewayTest {

    @Inject
    lateinit var orderGateway: OrderGateway

    @InjectMock
    lateinit var orderRepository: OrderRepository

    @InjectMock
    lateinit var orderDBMapper: OrderDBMapper


    @Test
    fun `given order saved when call findAll should return order`() {

        // given
        val orderDB = OrderDB(
            id = 10,
            userId = "1010"
        )

        val order = Order(
            id = 10,
            userId = "1010"
        )

        `when`(orderRepository.listAll())
            .thenReturn(
                listOf(
                    orderDB
                )
            )

        `when`(orderDBMapper.toDomain(orderDB))
            .thenReturn(order)

        // when
        val result = orderGateway.findAll()

        //then
        assertEquals(result.size, 1)
    }
}
