package chapter8.v4

import chapter8.IDomainLogger
import chapter8.IMessageBus

class EventDispatcher(
    private val _messageBus: IMessageBus,
    private val _domainLogger: IDomainLogger
) {
    fun dispatch(events: List<IDomainEvent>) {
        events.forEach {
            when (it) {
                is EmailChangedEvent -> _messageBus.sendEmailChangedMessage(it.userId, it.newEmail)
                is UserTypeChangedEvent -> _domainLogger.userTypeHasChanged(it.userId, it.type, it.newType)
            }
        }
    }
}