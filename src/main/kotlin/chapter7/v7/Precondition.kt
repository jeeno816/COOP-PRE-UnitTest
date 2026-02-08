package chapter7.v7

object Precondition {
    fun requires(condition:Boolean){
        if(!condition) throw Exception()
    }
}