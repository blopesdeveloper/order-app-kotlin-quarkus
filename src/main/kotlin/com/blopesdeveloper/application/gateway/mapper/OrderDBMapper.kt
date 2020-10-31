package com.blopesdeveloper.application.gateway.mapper

import com.blopesdeveloper.application.gateway.entity.OrderDB
import com.blopesdeveloper.domain.entity.Order
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class OrderDBMapper {
    fun toDB(order: Order) =
        OrderDB(
            userId = order.userId
        )

    fun toDomain(orderDB: OrderDB) =
        Order(
            id = orderDB.id,
            userId = orderDB.userId
        )
}