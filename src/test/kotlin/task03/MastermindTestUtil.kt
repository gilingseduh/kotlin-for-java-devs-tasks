package task03

import org.junit.Assert
import week2.task03.Evaluation
import week2.task03.evaluateGuess

internal fun testEvaluation(first: String, second: String, positions: Int, letters: Int) {
    val evaluation = Evaluation(positions, letters)
    testEvaluationOneWay(secret = first, guess = second, expected = evaluation)
    testEvaluationOneWay(guess = second, secret = first, expected = evaluation)
}

internal fun testEvaluationOneWay(secret: String, guess: String, expected: Evaluation) {
    val evaluation = evaluateGuess(secret, guess)
    Assert.assertEquals("Wrong evaluation for secret=$secret, guess=$guess",
            expected, evaluation)
}
