package com.blopesdeveloper.application.gateway

import com.blopesdeveloper.application.gateway.entity.OrderDB
import io.quarkus.hibernate.orm.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class OrderRepository: PanacheRepository<OrderDB>