import java.io.File

data class Movement(var direction: String, var distance: Int)
data class Position(var x: Int, var y: Int, var aim: Int)

fun main() {
    println("aoc021 Challenge 2\n")

    val position = Position(0, 0, 0)
    File("src/main/resources/input2.txt").forEachLine {
        val split = it.split(" ")
        with(Movement(split[0], split[1].toInt())) {
            when (direction) {
                "forward" -> {
                    position.x += distance
                    position.y += position.aim * distance
                }
                "up"      -> position.aim -= distance
                "down"    -> position.aim += distance
            }
        }
    }

    println("Final position = $position")
    println("final value = ${position.x * position.y}")
}