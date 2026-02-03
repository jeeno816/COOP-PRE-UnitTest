package chapter6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime


class `Example 6-4` {
    @Test
    fun adding_a_comment_to_an_article(){
        val sut = Article()
        val text = "Comment text"
        val author = "John Doe"
        val now = LocalDateTime.now()

        sut.addComment(text,author,now)

        assertEquals(1,sut.comments.size)
        assertEquals(text,sut.comments[0].text)
        assertEquals(author,sut.comments[0].author)
        assertEquals(now,sut.comments[0].dateCreated)

    }
}