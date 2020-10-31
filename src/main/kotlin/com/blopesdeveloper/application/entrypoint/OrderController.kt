package com.blopesdeveloper.application.entrypoint

import com.blopesdeveloper.application.entrypoint.entity.OrderApi
import com.blopesdeveloper.application.entrypoint.entity.OrderApiMapper
import com.blopesdeveloper.domain.usecase.FindAllUseCase
import com.blopesdeveloper.domain.usecase.SaveUseCase
import org.intellij.lang.annotations.JdkConstants
import org.mapstruct.factory.Mappers
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class OrderController(
    @Inject val findAllUseCase: FindAllUseCase,
    @Inject val saveUseCase: SaveUseCase,
    @Inject val orderMapper: OrderApiMapper
) {

    @GET
    fun findAll() =
        findAllUseCase.execute()
            .map { orderMapper.toApi(it) }

    @POST
    fun save(orderApi: OrderApi) =
        saveUseCase.execute(orderMapper.toDomain(orderApi))
}