package com.blopesdeveloper.domain.usecase

import com.blopesdeveloper.domain.gateway.OrderGateway
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.inject.Singleton

@ApplicationScoped
class FindAllUseCase(@Inject val orderGateway: OrderGateway) {
    fun execute() = orderGateway.findAll();
}