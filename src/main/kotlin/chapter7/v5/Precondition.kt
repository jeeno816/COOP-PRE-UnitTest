package chapter7.v5

object Precondition {
    fun requires(condition:Boolean){
        if(!condition) throw Exception()
    }
}