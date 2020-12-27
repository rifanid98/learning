package kotlin01_fundamental.lesson35_closure

/**
 * Colusure
 *
 * - Closure adalah kemampuan membuat function, lambda atau anonymous function
 *   berinteraksi dengan data-data disekitarnya dalam scope yang sama.
 * - Harap gunakan fitur closure ini dengan bijak saat kita membuat aplikasi.
 */
fun main() {
    var counter: Int = 0
    val increment: () -> Unit = {
        println("Increment!")
        counter++
    }

    println(counter)
    increment()
    println(counter)
    increment()
    println(counter)
    increment()
    println(counter)
}