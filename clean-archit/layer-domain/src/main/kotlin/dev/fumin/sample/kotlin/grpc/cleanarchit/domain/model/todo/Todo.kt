package dev.fumin.sample.kotlin.grpc.cleanarchit.domain.model.todo

class Todo(
    val id: TodoId,
    title: String
) {

    var title: String = ""
        set(value) {
            if (value.isBlank()) {
                throw IllegalArgumentException("title must not be blank.")
            }
            field = value
        }

    init {
        this.title = title
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Todo

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }


}
