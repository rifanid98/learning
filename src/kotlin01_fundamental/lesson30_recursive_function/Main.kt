package kotlin01_fundamental.lesson30_recursive_function

fun main() {
    println(factorial(1))
    println(factorial(2))
    println(factorial(3))
    println(factorial(4))
    println(factorial(5))
}

/**
 * Recursive Function
 *
 * - Recursive Function adalah function yang memanggil dirinya sendiri
 * - Kadang dalam pekerjaan, kita sering menemukan kasus dimana menggunakan
 *   recursive function lebih mudah dibandingkan tidak menggunakan revursive
 *   function
 * - Contoh kasus yang lebih mudah diselesaikan dengan recursive function
 *   adalah factorial
 */
fun factorial(num: Int): Int {
    return when (num) {
        1 -> 1
        else -> num * factorial(num - 1)
    }
}