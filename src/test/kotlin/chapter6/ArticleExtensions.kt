package chapter6

import org.junit.jupiter.api.Assertions.assertEquals
import java.time.LocalDateTime


fun shouldContainNumberOfComments(article: Article, expected: Int){
    assertEquals(expected,article.comments.size)
}

fun withComment(article:Article, text:String , author:String, dateCreated: LocalDateTime){
    assertEquals(1,article.comments.size)
    assertEquals(text,article.comments[0].text)
    assertEquals(author,article.comments[0].author)
    assertEquals(dateCreated,article.comments[0].dateCreated)
}
