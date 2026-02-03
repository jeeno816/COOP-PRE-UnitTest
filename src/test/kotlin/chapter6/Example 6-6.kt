package chapter6

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime


class `Example 6-6` {
    @Test
    fun adding_a_comment_to_an_article(){
        val sut = Article()
        val comment = Comment("Comment text","John Doe",LocalDateTime.now())

        sut.addComment(comment.text,comment.author,comment.dateCreated)

        assertTrue(sut.comments.contains(comment))


    }
}