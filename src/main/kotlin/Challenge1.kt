import java.io.File

fun main() {
    println("aoc021 Challenge 1\n")

    var increases = 0
    var decreases = 0

    var previous: String? = null
    File("src/main/resources/Input1.txt").forEachLine { line ->
        if (previous == null) {
            println("$line (N/A - no previous measurement)")
        } else {
            when (compareValuesBy(line, previous) { it?.toInt() }) {
                1 -> {
                    println("$line (increased)")
                    increases++
                }
                -1 -> {
                    println("$line (decreased)")
                    decreases++
                }
            }
        }
        previous = line
    }

    println("number of measurements larger then the previous: $increases")
    println("number of measurements smaller then the previous: $decreases")
}
