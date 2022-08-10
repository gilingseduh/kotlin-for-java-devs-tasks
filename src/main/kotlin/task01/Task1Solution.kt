package task01

// Implement the function that checks whether a string is a valid identifier.
// A valid identifier is a non-empty string that starts with a letter or underscore and consists of only letters, digits and underscores.

fun isValidIdentifier(s: String): Boolean {
    if (s.isEmpty()) {
        return false
    }

    val firstLetter = s[0]
    if (!isLetter(firstLetter) && !isUnderscore(firstLetter)) {
        return false
    }

    for (i in 1 until s.length) {
        val currentChar = s[i]
        if (!isLetter(currentChar) && !isDigit(currentChar) && !isUnderscore(currentChar)) {
            return false
        }
    }

    return true
}

private fun isLetter(char: Char) = char in 'a'..'z' || char in 'A'..'Z'

private fun isUnderscore(char: Char) = char == '_'

private fun isDigit(char: Char) = char in '0'..'9'

fun main() {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}
