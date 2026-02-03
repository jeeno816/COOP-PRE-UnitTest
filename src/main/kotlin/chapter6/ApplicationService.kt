package chapter6

import java.time.LocalDateTime

class ApplicationService(private val _directoryName:String, maxEntriesPerFile:Int) {
    private val _auditManager:AuditManager_V3 = AuditManager_V3(maxEntriesPerFile)
    private val _persister = Persister()

    fun addRecord(visitorName:String,timeOfVisit: LocalDateTime){
        val files = _persister.readDirectory(_directoryName)
        val update = _auditManager.addRecord(files,visitorName,timeOfVisit)
        _persister.applyUpdate(_directoryName,update)
    }
}