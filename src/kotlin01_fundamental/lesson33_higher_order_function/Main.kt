package kotlin01_fundamental.lesson33_higher_order_function

/**
 * Higher Order Function
 *
 * - Higher Order Function adalah function yang menggunakan function
 *   sebagai parameter atau mengembalikan function
 * - Penggunakan HOF ini terkadang berguna ketika kita ingin membuat
 *   function yang general dan ingin mendapatkan input yang flexible
 *   berupa lambda, yang dideklarasikan oleh si user ketika memanggil
 *   function tersebut
 */
fun hello(name: String, stringTransformer: (String) -> String): String {
    return "Hello ${stringTransformer(name)}"
}

fun main() {
    /* Cara 1 */
    val upperTransform: (String) -> String = {string: String -> string.toUpperCase()}
    val lowerTransform: (String) -> String = {string: String -> string.toLowerCase()}

    println(hello("Adnin", upperTransform))
    println(hello("Adnin", lowerTransform))

    /* Cara 2: Trailing Lambda */
    println(hello("Adnin"){string: String -> string.toUpperCase()})
    println(hello("Adnin"){string: String -> string.toLowerCase()})
}