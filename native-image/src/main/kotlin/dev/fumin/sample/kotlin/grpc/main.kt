package dev.fumin.sample.kotlin.grpc

import io.grpc.ServerBuilder

fun main() {
    val port = System.getenv("PORT").toInt()
    println("start grpc server on $port")
    ServerBuilder.forPort(port)
        .addService(TodoService())
        .build()
        .start()
        .awaitTermination()
}
