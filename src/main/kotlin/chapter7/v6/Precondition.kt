package chapter7.v6

object Precondition {
    fun requires(condition:Boolean){
        if(!condition) throw Exception()
    }
}