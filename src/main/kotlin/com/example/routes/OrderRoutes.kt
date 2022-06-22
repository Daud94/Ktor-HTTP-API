package com.example.routes

import com.example.models.orderSorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.listOrderRoutes() {
    get("/order") {
        if (orderSorage.isNotEmpty()) {
            call.respond(orderSorage)
        }
    }
}

fun Route.getOrderRoute() {
    get("/order/{id?}") {
        val id = call.parameters["id"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)

        val order = orderSorage.find { it.number == id } ?: return@get call.respondText(
            "Not Found",
            status = HttpStatusCode.NotFound
        )

        call.respond(order)


    }
}

fun Route.totalizeOrderRoute() {
    get("/order/{id?}/total") {
        val id = call.parameters["id"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)

        val order = orderSorage.find { it.number == id } ?: return@get call.respondText(
            "Not Found",
            status = HttpStatusCode.NotFound
        )

        val total = order.contents.sumOf { it.price * it.amount }
        call.respond(total)
    }
}

