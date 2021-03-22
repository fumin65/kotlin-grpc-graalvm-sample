package dev.fumin.sample.kotlin.grpc.cleanarchit.domain.model.todo

interface TodoRepository {

    fun id(): TodoId

    fun todoFor(id: TodoId): Todo?

    fun register(todo: Todo)

    fun save(todo: Todo)

    fun delete(todo: Todo)

}
