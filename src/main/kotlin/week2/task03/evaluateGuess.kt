package week2.task03

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var mutableGuess = guess
    var mutableSecret = secret
    var rightPosition = 0
    var wrongPosition = 0
    for (i in guess.indices) {
        if (guess[i] == secret[i]) {
            rightPosition++
            mutableGuess = mutableGuess.replaceRange(i, i + 1, "-")
            mutableSecret = mutableSecret.replaceRange(i, i + 1, "-")
        }
    }
    for (i in guess.indices) {
        if (mutableGuess[i] != '-') {
            for (j in secret.indices) {
                if (guess[i] == secret[j] && mutableSecret[j] != '-') {
                    wrongPosition++
                    mutableSecret = mutableSecret.replaceRange(j, j + 1, "-")
                    break
                }
            }
        }
    }

    return Evaluation(rightPosition, wrongPosition)
}
