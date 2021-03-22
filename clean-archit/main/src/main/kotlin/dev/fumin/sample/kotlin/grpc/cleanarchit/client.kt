package dev.fumin.sample.kotlin.grpc.cleanarchit

import dev.fumin.sample.kotlin.grpc.cleanarchit.presentation.grpc.CleanArchit
import dev.fumin.sample.kotlin.grpc.cleanarchit.presentation.grpc.TodoServiceGrpc
import io.grpc.ManagedChannelBuilder

fun main() {
    val channel = ManagedChannelBuilder
        .forAddress("localhost", 9000)
        .usePlaintext()
        .build()
    val client = TodoServiceGrpc.newBlockingStub(channel)
    val todo = client.create(
        CleanArchit.RegisterTodoRequest
            .newBuilder()
            .setTitle("sample todo")
            .build()
    )
    println(todo)
}
