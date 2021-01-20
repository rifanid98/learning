package kotlin04_collection.lesson04_pair

/**
 * Pair
 *
 * - Sebelum kita bahas collection Map, ada baiknya kita mengenal Pair.
 * - Pair adalah representasi dari data yang berpasangan.
 */
fun main() {
    val pairName: Pair<String, String> = Pair("name", "Adnin")
    println(pairName.first)
    println(pairName.second)

    val pairAge: Pair<String, Int> = Pair("age", 22)
    println(pairAge.first)
    println(pairAge.second)

    val pairMarried: Pair<String, Boolean> = "married" to false
    println(pairMarried.first)
    println(pairMarried.second)
}