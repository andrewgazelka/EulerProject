import java.nio.file.Files
import java.nio.file.Paths

class Problem24 {

}


class Sudoku(val rows: List<List<Int>>) {
    fun solve(){
        rows.forEachIndexed{ i, list ->

            list.forEachIndexed { k, element ->

            }
        }
    }
}

fun Int.nextSeq() {

}

fun main() {
    var nums = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9) //

//    println(nextIter(nums))

    val path = Paths.get("output.txt")
    val newBufferedWriter = Files.newBufferedWriter(path)
    newBufferedWriter.use {br ->
        repeat(1_000_000 - 1) {
            nums = nextIter(nums)
        }
    }
    println(nums)

}

fun nextIter(nums: List<Int>): List<Int> {
    val lastIndex = nums.lastIndex
    var i = lastIndex
    while (i > 0 && nums[i - 1] > nums[i]) i-- // go until at beginning of non-increasing sequence

    if(i == 0) throw IllegalStateException("can't find next iter for: $nums")

    var j = lastIndex
    while (nums[j] <= nums[i - 1]) j--

    val swapped = nums.swap(i - 1, j)

    return swapped.slice(0 until i) + swapped.slice(i..lastIndex).reversed()
}

private fun <E> List<E>.swap(i: Int, j: Int): List<E> {
    val mutableList = this.toMutableList()

    val a = this[i]
    val aTemp = a
    val b = this[j]

    mutableList[i] = b
    mutableList[j] = aTemp

    return mutableList.toList()

}


