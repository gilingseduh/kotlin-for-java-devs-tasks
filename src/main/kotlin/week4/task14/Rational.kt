package week4.task14

import java.math.BigInteger

class Rational(n: BigInteger, d: BigInteger) {
    val numer: BigInteger
    val denom: BigInteger

    init {
        val gcd = n.gcd(d)
        val sign = d.signum().toBigInteger()
        numer = n / gcd * sign
        denom = d / gcd * sign
    }

    operator fun plus(rational: Rational): Rational {
        val b = denom * rational.denom
        val a = (b / denom * numer) + (b / rational.denom * rational.numer)
        return Rational(a, b)
    }

    operator fun minus(rational: Rational): Rational {
        val b = denom * rational.denom
        val a = (b / denom * numer) - (b / rational.denom * rational.numer)
        return Rational(a, b)
    }

    operator fun times(rational: Rational): Rational {
        val a = numer * rational.numer
        val b = denom * rational.denom
        return Rational(a, b)
    }

    operator fun div(rational: Rational): Rational {
        val a = numer * rational.denom
        val b = denom * rational.numer
        return Rational(a, b)
    }

    operator fun unaryMinus(): Rational {
        val a = -numer
        val b = denom
        return Rational(a, b)
    }

    operator fun compareTo(rational: Rational): Int {
        if (denom == rational.denom) {
            if (numer == rational.numer) return 0
            if (numer < rational.numer) return -1
            return 1
        }

        val a = numer * rational.denom
        val b = rational.numer * denom
        if (a == b) return 0
        if (a < b) return -1
        return 1
    }

    operator fun rangeTo(rational: Rational): Pair<Rational, Rational> {
        return Pair(this, rational)
    }

    override fun toString(): String {
        if (denom == 1.toBigInteger()) return numer.toString()

        val gcd = numer.gcd(denom)

        if (denom / gcd == 1.toBigInteger()) return (numer / gcd).toString()

        if (((numer / gcd).toString().contains("-") && (denom / gcd).toString().contains("-")) ||
            (denom / gcd).toString().contains("-")) {
            return (-numer / gcd).toString() + "/" + (-denom / gcd).toString()
        }

        return (numer / gcd).toString() + "/" + (denom / gcd).toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false
        if (toString() != other.toString()) return false
        return true
    }

    override fun hashCode(): Int {
        var result = numer.hashCode()
        result = 31 * result + denom.hashCode()
        return result
    }
}

infix fun Number.divBy(i: Number): Rational {
    fun Long.toBigInteger(): BigInteger = BigInteger.valueOf(this)
    fun Int.toBigInteger(): BigInteger = BigInteger.valueOf(toLong())

    when (i) {
        is Int -> return Rational(toInt().toBigInteger(), i.toBigInteger())
        is Long -> return Rational(toLong().toBigInteger(), i.toBigInteger())
    }

    return Rational(this as BigInteger, i as BigInteger)
}

fun String.toRational(): Rational {
    val s = split("/")

    if (s.size == 1) return Rational(s[0].toBigInteger(), 1.toBigInteger())

    return Rational(s[0].toBigInteger(), s[1].toBigInteger())
}

operator fun Pair<Rational, Rational>.contains(rational: Rational): Boolean {
    if (rational >= first && rational <= second) return true
    return false
}

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println(
        "912016490186296920119201192141970416029".toBigInteger() divBy
                "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2
    )
}
