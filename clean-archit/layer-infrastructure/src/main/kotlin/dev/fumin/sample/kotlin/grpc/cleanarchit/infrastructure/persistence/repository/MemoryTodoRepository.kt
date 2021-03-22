package dev.fumin.sample.kotlin.grpc.cleanarchit.infrastructure.persistence.repository

import dev.fumin.sample.kotlin.grpc.cleanarchit.domain.model.todo.Todo
import dev.fumin.sample.kotlin.grpc.cleanarchit.domain.model.todo.TodoId
import dev.fumin.sample.kotlin.grpc.cleanarchit.domain.model.todo.TodoRepository
import java.util.*

class MemoryTodoRepository : TodoRepository {

    private val todos: MutableList<Todo> = mutableListOf()

    override fun id(): TodoId = TodoId(UUID.randomUUID().toString())

    override fun todoFor(id: TodoId): Todo? {
        return todos.find { it.id == id }
    }

    override fun register(todo: Todo) {
        todos.add(todo)
    }

    override fun save(todo: Todo) {
        val index = todos.indexOf(todo)
        todos[index] = todo
    }

    override fun delete(todo: Todo) {
        todos.remove(todo)
    }

}
