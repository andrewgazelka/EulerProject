import kotlin.math.sqrt

fun main() {
    val map = (1..20).map { it.primeFactors().groupBy { it } }
}

tailrec fun Int.primeFactors(factorList: List<Int> = emptyList()): List<Int> {
    val to = sqrt(this.toDouble()).toInt()
    for (i in 2..to) {
        if (this % i == 0) {
            return (this/i).primeFactors(factorList)
        }
    }
    return factorList
}
