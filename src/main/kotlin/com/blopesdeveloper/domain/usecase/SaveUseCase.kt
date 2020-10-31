package com.blopesdeveloper.domain.usecase

import com.blopesdeveloper.application.gateway.OrderGateway
import com.blopesdeveloper.domain.entity.Order
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.inject.Singleton

@ApplicationScoped
class SaveUseCase(@Inject val orderGateway: OrderGateway) {

    fun execute(order: Order) = orderGateway.save(order)
}