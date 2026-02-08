package chapter7.v8

object Precondition {
    fun requires(condition:Boolean){
        if(!condition) throw Exception()
    }
}