package chapter1

fun isStringLong(input: String): Boolean{
    if (input.length > 5)
        return true
    return false
}

fun isStringLong2(input: String) = input.length > 5
