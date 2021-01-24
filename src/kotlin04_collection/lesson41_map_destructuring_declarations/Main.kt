package kotlin04_collection.lesson41_map_destructuring_declarations

/**
 * Destructuring Declarations di Map
 *
 * - Sebelumnya kita telah belajar destructuring declaration.
 * - Map menyimpan datanya dalam Entry<K,V>, dimana Entry memiliki function
 *   component1() untuk mendapatkan Key, dan component2() untuk mendapatkan Value.
 * - Hal ini jadi memungkinkan kita melakukan desctructuring di Entry Map.
 */
fun main() {
    val map: Map<String, String> = mapOf(
        "a" to "Adnin",
        "r" to "Rifandi",
        "s" to "Sutanto"
    )

    for ((key, value) in map) {
        println("$key : $value")
    }

    map.forEach { (key, value) -> println("$key : $value") }
    map.forEach { entry -> println("${entry.component1()} : ${entry.component2()}") }
}