package chapter8.v4

data class EmailChangedEvent(val userId: Int, val newEmail: String): IDomainEvent