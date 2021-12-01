import java.io.File

fun main() {
    println("aoc021 Challenge 1\n")

    var previous: String? = null
    File("src/main/resources/Input1.txt").forEachLine { line ->
        if (previous == null) {
            println("$line (N/A - no previous measurement)")
        } else {
            when (compareValuesBy(line, previous) { it?.toInt() }) {
                1 -> println("$line (increased)")
                -1 -> println("$line (decreased)")
            }
        }
        previous = line
    }
}
