package dev.fumin.sample.kotlin.grpc.cleanarchit.application.usecase.todo

import dev.fumin.sample.kotlin.grpc.cleanarchit.domain.model.todo.Todo
import dev.fumin.sample.kotlin.grpc.cleanarchit.domain.model.todo.TodoRepository

class RegisterTodoUseCase(
    private val repository: TodoRepository
) {

    fun handle(title: String): TodoData {
        val id = repository.id()
        val todo = Todo(id, title)
        repository.register(todo)
        return TodoData(todo.id.value, todo.title)
    }

}
