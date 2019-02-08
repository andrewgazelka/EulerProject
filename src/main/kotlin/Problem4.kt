val Int.isPalindrome: Boolean
    get() {
        val string = this.toString()
        val midpoint = string.length / 2

        val midpointEnd = midpoint
        val midpointStart = if (string.length % 2 == 0) midpoint else midpoint + 1

        val beginning = string.substring(0 until midpointEnd)
        val end = string.substring(midpointStart until string.length).reversed()
        return beginning == end
    }

fun main() {
    largestPalendrome()?.also { println(it) }
}
fun largestPalendrome(): PalindromeResult? {

    var palindromeResult: PalindromeResult? = null
    for (a in 900..999) {
        for (b in 900..999) {
            val mult = a * b
            if (mult.isPalindrome) {
                if (palindromeResult == null || palindromeResult.result < mult) {
                    palindromeResult = PalindromeResult(a, b, mult)
                }
            }
        }
    }
    return palindromeResult
}

data class PalindromeResult(val a: Int, val b: Int, val result: Int)
