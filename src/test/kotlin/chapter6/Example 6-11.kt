package chapter6


import org.junit.jupiter.api.Test
import io.mockk.*
import java.time.LocalDateTime


class `Example 6-11` {
    @Test
    fun a_new_file_is_created_when_the_current_file_overflows(){
        val fileSystemMock = mockk<IFileSystem>(relaxed = true)
        every{fileSystemMock.getFiles("audits")} returns listOf("""audits/audit_1.txt""","""audits/audit_2.txt""")
        every{fileSystemMock.readAllLines("""audits/audit_2.txt""")} returns
                mutableListOf("Peter; 2019-04-06T16:30:00","Jane; 2019-04-06T16:40:00","Jack; 2019-04-06T17:00:00")
        val sut = AuditManager_V2(3,"audits",fileSystemMock)

        sut.addRecord("Alice", LocalDateTime.of(2019,4,6,18,0,0))

        verify(exactly = 1){fileSystemMock.writeAllText("""audits/audit_3.txt""","Alice;2019-04-06T18:00:00")}

    }
}