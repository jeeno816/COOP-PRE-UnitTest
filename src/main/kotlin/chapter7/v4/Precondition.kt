package chapter7.v4

object Precondition {
    fun requires(condition:Boolean){
        if(!condition) throw Exception()
    }
}