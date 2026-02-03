package chapter6


import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AuditManager_V3 (private val _maxEntriesPerFile:Int){
    fun addRecord(files:List<FileContent>, visitorName:String, timeOfVisit: LocalDateTime): FileUpdate{
        val sorted:List<Pair<Int,FileContent>> = sortByIndex(files)

        val newRecord = visitorName + ';' + timeOfVisit.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))

        if(sorted.isEmpty()){
            return FileUpdate("audit_1.txt",newRecord)
        }

        val (currentFileIndex,currentFile) = sorted.last()
        val lines:MutableList<String> = currentFile.lines.toMutableList()

        if( lines.size < _maxEntriesPerFile){
            lines.add(newRecord)
            val newContent = lines.joinToString("\r\n")
            return FileUpdate(currentFile.fileName,newContent)
        }else {
            val newIndex = currentFileIndex + 1
            val newName = "audit_$newIndex.txt"
            return FileUpdate(newName,newRecord)
        }
    }
    private val firstNumberRegex = Regex("""\d+""")
    fun sortByIndex(files:List<FileContent>):List<Pair<Int, FileContent>> = files.map{
        fileContent ->
        val idx = firstNumberRegex.find(fileContent.fileName)?.value?.toInt()?:Int.MAX_VALUE
        idx to fileContent
    }.sortedBy{it.first}

}