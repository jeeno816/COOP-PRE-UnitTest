package chapter6

import java.io.IOException
import java.time.LocalDateTime
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.time.format.DateTimeFormatter

class AuditManager_V1 (private val _maxEntriesPerFile:Int,private val _directoryName:String){
    fun addRecord(visitorName:String,timeOfVisit: LocalDateTime){
        val dir = Paths.get(_directoryName)
        val filePaths:List<String> = Files.list(dir).use{
            it.filter { Files.isRegularFile(it)}.map{it.toString()}.toList()
        }
        val sorted:List<Pair<Int,String>> = sortByIndex(filePaths)

        val newRecord = visitorName + ';' + timeOfVisit.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))

        if(sorted.isEmpty()){
            val newFile =dir.resolve("audit_1.txt")
            try{
                Files.writeString(newFile,newRecord,StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)
                return
            }catch(_:FileAlreadyExistsException){
                throw  IllegalStateException(""""audit_1.txt" named file already exists.""")
            }
        }

        val (currentFileIndex,currentFilePath) = sorted.last()
        val lines:MutableList<String> = Files.readAllLines(Paths.get(currentFilePath)).toMutableList()

        if( lines.size < _maxEntriesPerFile){
            lines.add(newRecord)
            val newContent = lines.joinToString("\r\n")
            try{
                Files.writeString(Paths.get(currentFilePath),newContent,StandardOpenOption.WRITE)
            }catch(_: IOException){
                throw IllegalStateException("Error writing to file $currentFilePath")
            }
        }else {
            val newIndex = currentFileIndex + 1
            val newName = "audit_$newIndex.txt"
            val newFile = dir.resolve(newName)
            try {
                Files.writeString(newFile, newRecord, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)
            } catch (_: FileAlreadyExistsException) {
                throw IllegalStateException(""""audit_$newIndex.txt" named file already exists.""")
            }
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