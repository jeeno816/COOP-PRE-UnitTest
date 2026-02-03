package chapter6


import java.time.LocalDateTime
import java.nio.file.Paths
import java.time.format.DateTimeFormatter

class AuditManager_V2 (private val _maxEntriesPerFile:Int, private val _directoryName:String,private val _fileSystem: IFileSystem){
    fun addRecord(visitorName:String,timeOfVisit: LocalDateTime){
        val filePaths:List<String> = _fileSystem.getFiles(_directoryName)
        val sorted:List<Pair<Int,String>> = sortByIndex(filePaths)

        val newRecord = visitorName + ';' + timeOfVisit.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))

        if(sorted.isEmpty()){
            val newFile = Paths.get(_directoryName).resolve("audit_1.txt").toString()
            _fileSystem.writeAllText(newFile,newRecord)
            return
        }

        val (currentFileIndex,currentFilePath) = sorted.last()
        val lines:MutableList<String> = _fileSystem.readAllLines(currentFilePath)

        if( lines.size < _maxEntriesPerFile){
            lines.add(newRecord)
            val newContent = lines.joinToString("\r\n")
            _fileSystem.writeAllText(currentFilePath,newContent)
        }else {
            val newIndex = currentFileIndex + 1
            val newName = "audit_$newIndex.txt"
            val newFile = Paths.get(_directoryName).resolve(newName).toString()
            _fileSystem.writeAllText(newFile,newRecord)
        }
    }
    private val firstNumberRegex = Regex("""\d+""")
    fun sortByIndex(filePaths:List<String>):List<Pair<Int,String>> = filePaths.map{
        path ->
        val fileName = Paths.get(path).fileName.toString()
        val idx = firstNumberRegex.find(fileName)?.value?.toInt()?:Int.MAX_VALUE
        idx to path
    }.sortedBy{it.first}

}