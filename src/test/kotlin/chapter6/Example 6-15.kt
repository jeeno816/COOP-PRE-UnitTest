package chapter6

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime


class `Example 6-15` {
    @Test
    fun a_new_file_is_created_when_the_current_file_overflows(){
        val sut = AuditManager_V3(3)
        val files = listOf(FileContent("audit_1.txt",emptyList()), FileContent("audit_2.txt",listOf(
            "Peter; 2019-04-06T16:30:00","Jane; 2019-04-06T16:40:00","Jack; 2019-04-06T17:00:00"
        )))

        val update = sut.addRecord(files,"Alice",LocalDateTime.of(2019,4,6,18,0,0))

        assertEquals("audit_3.txt",update.fileName)
        assertEquals("Alice;2019-04-06T18:00:00",update.newContent)

    }
}