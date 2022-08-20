package task19.gameOfFifteen

import org.junit.Assert
import org.junit.Test
import week5.task19.gameOfFifteen.RandomGameInitializer
import week5.task19.gameOfFifteen.isEven

class TestGameOfFifteenInitializer {
    @Test
    fun testInitialPermutationIsNotTrivial() {
        val initializer = RandomGameInitializer()
        Assert.assertNotEquals("The initial permutation must not be trivial",
            (1..15).toList(), initializer.initialPermutation)
    }

    @Test
    fun testInitialPermutationIsEven() {
        val initializer = RandomGameInitializer()
        Assert.assertNotEquals("The initial permutation must be even",
            isEven(initializer.initialPermutation))
    }
}
