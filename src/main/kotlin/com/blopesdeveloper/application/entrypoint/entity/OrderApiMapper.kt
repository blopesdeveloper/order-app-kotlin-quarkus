package com.blopesdeveloper.application.entrypoint.entity

import com.blopesdeveloper.domain.entity.Order
import javax.inject.Singleton

@Singleton
class OrderApiMapper {
    fun toApi(order: Order) =
        OrderApi(
            id = order.id,
            userId = order.userId
        )

    fun toDomain(orderApi: OrderApi) =
        Order(
            id = orderApi.id,
            userId = orderApi.userId
        )
}