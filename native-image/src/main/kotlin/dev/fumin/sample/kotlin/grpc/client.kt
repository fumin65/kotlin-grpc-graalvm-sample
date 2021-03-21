package dev.fumin.sample.kotlin.grpc

import io.grpc.ManagedChannelBuilder

fun main() {
    val channel = ManagedChannelBuilder
        .forAddress("localhost", 9000)
        .usePlaintext()
        .build()
    val client = TodoServiceGrpc.newBlockingStub(channel)
    val todo = client.create(
        TodoOuterClass.CreateTodoRequest
            .newBuilder()
            .setTitle("sample todo")
            .build()
    )
    println(todo)
}
