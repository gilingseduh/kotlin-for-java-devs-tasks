package week4.task10

// Implement the property 'foo' so that it produced a different value on each access.
// Note that you can modify the code outside the 'foo' getter (e.g. add additional imports or properties).

var count = 0
val foo: Int
    get() = count++

fun main() {
    // The values should be different:
    println(foo)
    println(foo)
    println(foo)
}
