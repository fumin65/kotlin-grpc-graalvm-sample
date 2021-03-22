package dev.fumin.sample.kotlin.grpc.cleanarchit

import dev.fumin.sample.kotlin.grpc.cleanarchit.application.usecase.todo.RegisterTodoUseCase
import dev.fumin.sample.kotlin.grpc.cleanarchit.domain.model.todo.TodoRepository
import dev.fumin.sample.kotlin.grpc.cleanarchit.infrastructure.persistence.repository.MemoryTodoRepository
import dev.fumin.sample.kotlin.grpc.cleanarchit.presentation.grpc.TodoService
import io.grpc.ServerBuilder
import org.kodein.di.*

fun main() {

    val di = DI {
        bind<TodoRepository>() with singleton { MemoryTodoRepository() }
        bind<RegisterTodoUseCase>() with provider { RegisterTodoUseCase(instance()) }
        bind<TodoService>() with provider { TodoService(instance()) }
    }

    println("start grpc server")
    ServerBuilder.forPort(9000)
        .addService(di.direct.instance<TodoService>())
        .build()
        .start()
        .awaitTermination()
}
