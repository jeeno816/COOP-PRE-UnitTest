package chapter7.v3

object Precondition {
    fun requires(condition:Boolean){
        if(!condition) throw Exception()
    }
}