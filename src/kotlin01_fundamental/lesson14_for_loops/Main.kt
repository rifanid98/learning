package kotlin01_fundamental.lesson14_for_loops

/**
 * For loop digunakan untuk perulangan
 * terhadap data iterator seperti array
 * dan range
 */
fun main() {
    /**
     * For Loop Data Range
     */
    println("----- For Loop Data Range")
    /* cara 1 */
    println("--- cara 1")
    for (i: Int in 0..5) {
        println(i)
    }
    // or
    /*
        val values: Array<Int> = arrayOf(1, 2, 3, 4, 5)
        for (i: Int in 0..values.size) {
            println(i)
        }
    */
    /* cara 2 */
    println("--- cara 2")
    for (i: Int in 0..10 step 2) {
        println(i)
    }
    /* cara 3 */
    println("--- cara 3")
    for (i: Int in 5 downTo 0) {
        println(i)
    }
    /* cara 4 */
    println("--- cara 4")
    for (i: Int in 10 downTo 0 step 2) {
        println(i)
    }

    println()
    /**
     * For Loop Data Array
     */
    println("----- For Loop Data Array")
    val names: Array<String> = arrayOf("Adnin", "Rifandi", "Sutanto", "Putra")
    for (name: String in names) {
        println(name)
    }
}