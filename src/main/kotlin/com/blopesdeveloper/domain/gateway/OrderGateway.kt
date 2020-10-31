package com.blopesdeveloper.domain.gateway

import com.blopesdeveloper.domain.entity.Order

interface OrderGateway {
    fun save(order: Order): Order
    fun deleteById(id: Long)
    fun findAll(): List<Order>
    fun findById(id: Long): Order
}