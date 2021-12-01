import java.io.File

fun main() {
    println("aoc021 Challenge 1\n")

    var increases = 0
    var decreases = 0
    var noChanges = 0

    var previousWindow: Int? = null

    val measurements = mutableListOf<Int>()
    File("src/main/resources/Input1.txt").forEachLine { measurements.add(it.toInt()) }

    for (index in measurements.indices) {
        if (index + 3 > measurements.size) break

        val window = measurements.subList(index, index + 3)
        val result = window.reduce { a, b -> a + b }

        if (previousWindow == null) {
            println("$result (N/A - no previous measurement)")
        } else {
            when (compareValuesBy(result, previousWindow) { it }) {
                1 -> {
                    println("$result (increased)")
                    increases++
                }
                -1 -> {
                    println("$result (decreased)")
                    decreases++
                }
                0 -> {
                    println("$result (no change)")
                    noChanges++
                }
            }
        }
        previousWindow = result
    }

    println("number of measurements larger then the previous: $increases")
    println("number of measurements smaller then the previous: $decreases")
    println("number of measurements equal to the previous: $noChanges")
}
