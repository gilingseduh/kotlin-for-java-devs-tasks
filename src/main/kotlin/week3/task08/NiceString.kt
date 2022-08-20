package week3.task08

// Complete the following implementation of 'evaluateGuess()' function.
// Then compare your solution with the solution written in a functional style.

fun String.isNice(): Boolean {
    val noBuBaBe = setOf("bu", "ba", "be").none { contains(it) }
    val containsAtLeastThreeVowels = count { it in "aeiou" } >= 3
    val containsDoubleLetters = zipWithNext().any { it.first == it.second }

    return listOf(noBuBaBe, containsAtLeastThreeVowels, containsDoubleLetters)
        .count { it } >= 2
}
