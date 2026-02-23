package chapter8.v4

import chapter8.UserType

data class UserTypeChangedEvent(val userId: Int, val type: UserType, val newType: UserType): IDomainEvent
