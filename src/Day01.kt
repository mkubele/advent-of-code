fun main() {
    val input = readInput("Day01").map { it.toInt() }
    val resultMap = mutableMapOf<Int, Result>()
    val resultList = mutableListOf<Int>()

    fun compareValuesResult(index: Int, currentValue: Int, previousValue: Int) {
        when {
            currentValue > previousValue -> resultMap[index] = Result.INCREASE
            currentValue < previousValue -> resultMap[index] = Result.DECREASE
            currentValue == previousValue -> resultMap[index] = Result.NO_CHANGE
        }
    }

    fun getResults(input: List<Int>) {
        for (i in input.indices) {
            try {
                compareValuesResult(i, input[i], input[i - 1])
            } catch (e: IndexOutOfBoundsException) {
                resultMap[i] = Result.NA
            }
        }
    }

    fun part1(input: List<Int>): Int {
        getResults(input)

        return resultMap.filter { it.value == Result.INCREASE }.size
    }

    fun getSum(index: Int) = input[index] + input[index + 1] + input[index + 2]

    fun part2(input: List<Int>): Int {
        for (i in input.indices) {
            try {
                resultList.add(getSum(i))
            } catch (_: IndexOutOfBoundsException) {
            }
        }

        getResults(resultList)

        return resultMap.filter { it.value == Result.INCREASE }.size
    }

//    println(part1(input))
//    println(part2(input))
}

enum class Result {
    NA,
    INCREASE,
    DECREASE,
    NO_CHANGE
}