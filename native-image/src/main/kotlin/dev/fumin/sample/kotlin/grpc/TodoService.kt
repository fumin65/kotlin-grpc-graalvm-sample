package dev.fumin.sample.kotlin.grpc

import io.grpc.stub.StreamObserver
import java.util.*

class TodoService : TodoServiceGrpc.TodoServiceImplBase() {

    override fun create(
        request: TodoOuterClass.CreateTodoRequest,
        responseObserver: StreamObserver<TodoOuterClass.Todo>
    ) {

        val todo = TodoOuterClass.Todo
            .newBuilder()
            .setId(UUID.randomUUID().toString())
            .setTitle(request.title)
            .build()

        responseObserver.apply {
            onNext(todo)
            onCompleted()
        }

    }

}
