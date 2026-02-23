package chapter8

class DomainLogger(private val _logger:ILogger) :IDomainLogger{
    override fun userTypeHasChanged(userId: Int, oldType: UserType, newType: UserType) {
        _logger.info("User $userId changed type from $oldType to $newType")
    }
}