import java.io.File

data class Movement(var direction: String, var distance: Int)
data class Position(var x: Int, var y: Int)

fun main() {
    println("Challenge 2")

    val position = Position(0, 0)
    File("src/main/resources/input2.txt").forEachLine {
        val split = it.split(" ")
        with(Movement(split[0], split[1].toInt())) {
            when (direction) {
                "forward" -> position.x += distance
                "up"      -> position.y -= distance
                "down"    -> position.y += distance
            }
        }
    }

    println("Final position = $position")
    println("final value = ${position.x * position.y}")
}