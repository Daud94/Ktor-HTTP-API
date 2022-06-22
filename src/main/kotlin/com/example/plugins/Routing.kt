package com.example.plugins

import com.example.routes.customerRouting
import com.example.routes.getOrderRoute
import com.example.routes.listOrderRoutes
import com.example.routes.totalizeOrderRoute
import io.ktor.server.routing.*
import io.ktor.server.application.*


fun Application.configureRouting() {
    routing {
        customerRouting()
        listOrderRoutes()
        getOrderRoute()
        totalizeOrderRoute()
    }
}
