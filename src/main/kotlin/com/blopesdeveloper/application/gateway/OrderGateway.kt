package com.blopesdeveloper.application.gateway

import com.blopesdeveloper.application.gateway.mapper.OrderDBMapper
import com.blopesdeveloper.domain.entity.Order
import org.intellij.lang.annotations.JdkConstants
import org.mapstruct.factory.Mappers
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional
import com.blopesdeveloper.domain.gateway.OrderGateway as Gateway

@ApplicationScoped
class OrderGateway(
    @Inject val orderRepository: OrderRepository,
    @Inject val orderMapper: OrderDBMapper
) : Gateway {

    @Transactional
    override fun save(order: Order) =
        orderMapper.toDB(order)
            .run {
                orderRepository.persist(this)
                order
            }

    @Transactional
    override fun deleteById(id: Long) {
        orderRepository.deleteById(id)
    }

    override fun findAll(): List<Order> =
        orderRepository.listAll()
            .map { orderMapper.toDomain(it) }

    override fun findById(id: Long) =
        orderMapper.toDomain(orderRepository.findById(id))
}