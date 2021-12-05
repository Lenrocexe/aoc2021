import java.io.File

data class BitFlags(var zeroes: Int, var ones: Int) {
    fun zeroesMostCommon() = zeroes > ones
}

fun main() {
    println("aoc021 Challenge 3\n")

    var gammaRate = ""
    var epsilonRate = ""

    var buckets: List<BitFlags>? = null

    File("src/main/resources/input3.txt").forEachLine {

        if (buckets == null) {
            buckets = List(it.count()) { BitFlags(0, 0) }
        }

        it.forEachIndexed { index, c ->
            if (c == '0') {
                buckets!![index].zeroes++
            } else if (c == '1') {
                buckets!![index].ones++
            }
        }
    }

    println(buckets)

    buckets!!.forEach {
        gammaRate += if (it.zeroesMostCommon()) "0" else "1"
        epsilonRate += if (it.zeroesMostCommon()) "1" else "0"
    }

    println("Gamma = $gammaRate")
    println("Epsilon = $epsilonRate")

    println("Power consumption = ${Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2)}")
}