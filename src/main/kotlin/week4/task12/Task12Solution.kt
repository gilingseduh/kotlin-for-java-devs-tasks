package week4.task12

// Complete the declaration of the class A without throwing NullPointerException explicitly so that NPE was thrown during the creation of its subclass B instance.

open class A(val value: String) {
    init {
        value.length
    }
}

class B(value: String) : A(value)

fun main() {
    val b = B("a")
    println(b.value)
}
