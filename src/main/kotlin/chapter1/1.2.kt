package chapter1

var wasLastStringLong = false

fun isStringLong3(input: String): Boolean{
    val result = input.length > 5
    wasLastStringLong = result
    return result
}




