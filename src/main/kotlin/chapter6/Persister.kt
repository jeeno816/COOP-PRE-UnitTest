package chapter6

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

class Persister {
    fun readDirectory(directoryName:String):List<FileContent>{
        val dir = Paths.get(directoryName)
        val filePaths:List<String> = Files.list(dir).use{
            it.filter { Files.isRegularFile(it)}.map{it.toString()}.toList()
        }
        val listOfFileContent = filePaths.map{
            val fileName = Paths.get(it).fileName.toString()
            val lines = Files.readAllLines(Paths.get(it))
            FileContent(fileName,lines)
        }
        return listOfFileContent
    }
    fun applyUpdate(directoryName:String,update:FileUpdate){
        val dir = Paths.get(directoryName)
        val filePath = dir.resolve(update.fileName)


        Files.writeString(
            filePath,
            update.newContent,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING,
            StandardOpenOption.APPEND
        )
    }
}