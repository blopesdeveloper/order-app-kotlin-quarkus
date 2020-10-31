package com.blopesdeveloper.application.entrypoint.entity

import javax.json.bind.annotation.JsonbCreator
import javax.json.bind.annotation.JsonbProperty

data class OrderApi @JsonbCreator constructor(@JsonbProperty(value = "id", nillable = true) var id: Long?,
                                              @JsonbProperty("user_id") val userId: String)