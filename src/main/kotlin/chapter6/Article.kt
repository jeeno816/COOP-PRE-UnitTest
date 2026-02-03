package chapter6

import java.time.LocalDateTime

class Article {
    val comments = mutableListOf<Comment>()

    fun addComment(text:String, author:String,postTime:LocalDateTime=LocalDateTime.now()){
        comments.add(Comment(text,author,postTime))
    }

}