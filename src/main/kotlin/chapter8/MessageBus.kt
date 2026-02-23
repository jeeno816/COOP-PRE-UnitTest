package chapter8

class MessageBus : IMessageBus {
    override fun sendEmailChangedMessage(userId: Int, newEmail: String) {}
}