package dev.fumin.sample.kotlin.grpc

import io.grpc.ServerBuilder

fun main() {
    println("start grpc server")
    ServerBuilder.forPort(9000)
        .addService(TodoService())
        .build()
        .start()
        .awaitTermination()
}
