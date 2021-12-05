import java.io.File

data class BitFlags(var zeroes: Int, var ones: Int) {
    fun zeroesMostCommon() = zeroes > ones
    fun zeroesLeastCommon() = zeroes < ones
    fun equalNumbers() = zeroes == ones

    fun mostCommon(precedence: Char? = null) =
        if (equalNumbers() && precedence != null)
            precedence
        else if (zeroesMostCommon())
            '0'
        else
            '1'

    fun leastCommon(precedence: Char? = null) =
        if (equalNumbers() && precedence != null)
            precedence
        else if (zeroesLeastCommon())
            '0'
        else
            '1'
}

fun main() {
    println("aoc021 Challenge 3 part 2\n")

    val lines = File("src/main/resources/input3.txt").readLines()

    val oxygen = getOxygen(lines, '1')
    val co2scrubber = getCO2Scrubber(lines, '0')

    println("oxygen              = $oxygen")
    println("co2scrubber         = $co2scrubber")

    println("Life support rating = ${Integer.parseInt(oxygen, 2) * Integer.parseInt(co2scrubber, 2)}")
}

fun getOxygen(items: List<String>, commonBit: Char, index: Int = 0): String {
    val buckets = getBuckets(items)
    if (items.count() == 1) return items.first()
    val result = items.filter {
        it[index] == buckets[index].mostCommon(commonBit)
    }

    return getOxygen(result, commonBit, index + 1)
}

fun getCO2Scrubber(items: List<String>, commonBit: Char, index: Int = 0): String {
    val buckets = getBuckets(items)
    if (items.count() == 1) return items.first()
    val result = items.filter {
        it[index] == buckets[index].leastCommon(commonBit)
    }

    return getCO2Scrubber(result, commonBit, index + 1)
}

fun getBuckets(items: List<String>): List<BitFlags> {
    val buckets = List(items.first().count()) { BitFlags(0, 0) }

    items.forEach {
        it.forEachIndexed { index, c ->
            if (c == '0') {
                buckets[index].zeroes++
            } else if (c == '1') {
                buckets[index].ones++
            }
        }
    }

    return buckets
}