fun main(args: Array<String>) {

    // Regular fib
    val fib = generateSequence(Pair(1, 2)) { Pair(it.second, it.first + it.second) }.map { it.first }

    fib
        .takeWhile { it < 4_000_000 }
        .forEach { println(it) }
}
