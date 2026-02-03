package chapter6


import org.junit.jupiter.api.Test
import java.time.LocalDateTime


class `Example 6-5` {
    @Test
    fun adding_a_comment_to_an_article(){
        val sut = Article()
        val text = "Comment text"
        val author = "John Doe"
        val now = LocalDateTime.now()

        sut.addComment(text,author,now)

        shouldContainNumberOfComments(sut,1)
        withComment(sut,text,author,now)


    }
}