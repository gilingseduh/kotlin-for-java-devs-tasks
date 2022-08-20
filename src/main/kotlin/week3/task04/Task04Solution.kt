package week3.task04

// Add and implement an extension function 'isEmptyOrNull()' on the type String?.
// It should return true, if the string is null or empty.

fun main() {
    val s1: String? = null
    s1.isEmptyOrNull() eq true

    val s2: String? = ""
    s2.isEmptyOrNull() eq true

    val s3 = "   "
    s3.isEmptyOrNull() eq false
}

infix fun <T> T.eq(other: T) {
    if (this == other) println("OK")
    else println("Error: $this != $other")
}

fun String?.isEmptyOrNull() = this == null || isEmpty()
