package dev.fumin.sample.kotlin.grpc.cleanarchit.presentation.grpc

import dev.fumin.sample.kotlin.grpc.cleanarchit.application.usecase.todo.RegisterTodoUseCase
import io.grpc.stub.StreamObserver

class TodoService(
    private val useCase: RegisterTodoUseCase
) : TodoServiceGrpc.TodoServiceImplBase() {

    override fun create(
        request: CleanArchit.RegisterTodoRequest,
        responseObserver: StreamObserver<CleanArchit.Todo>
    ) {
        val todo = useCase.handle(request.title).let {
            CleanArchit.Todo.newBuilder()
                .setId(it.id)
                .setTitle(it.title)
                .build()
        }

        responseObserver.apply {
            onNext(todo)
            onCompleted()
        }
    }

}
