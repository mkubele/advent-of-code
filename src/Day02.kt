fun main() {
    fun part1(input: List<String>): Int {
        var depth = 0
        var horizontal = 0

        val actions = input.map { it.split(" ") }

        for ((i, j) in actions) {
            val num = j.toInt()
            when (i) {
                "forward" -> horizontal += num
                "down" -> depth += num
                "up" -> depth -= num
            }
        }
        return depth * horizontal
    }

    fun part2(input: List<String>): Int {
        var depth = 0
        var horizontal = 0
        var aim = 0

        val actions = input.map { it.split(" ") }

        for ((i, j) in actions) {
            val num = j.toInt()
            when (i) {
                "down" -> aim += num
                "up" -> aim -= num
                "forward" -> {
                    horizontal += num
                    depth += aim * num
                }
            }
        }

        return depth * horizontal
    }

    val input = readInput("Day02")

//    println(part1(input))
//    println(part2(input))
}