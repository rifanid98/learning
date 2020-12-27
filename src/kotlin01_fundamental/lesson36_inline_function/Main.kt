package kotlin01_fundamental.lesson36_inline_function

/**
 * Inline Function
 *
 * - Inline Function adalah kemampuan di Kotlin untuk mengubah Higher Order Function
 *   menjadi inline function.
 * - Dimana dengan Inline Function, code di Higher Order Component akan diduplicate
 *   agar pada saat runtime, aplikasi tidak perlu membuat object lambda berulang-ulang
 */
inline fun hello(firstName: String, lastName: () -> String): String {
    return "Hello $firstName ${lastName()}"
}

/**
 * NoInline
 *
 * - Ketika kita menggunakan keyword noinline, maka parameter yang ditandai noinline
 *   tidak akan dibuat menjadi inline, tapi akan tetap dijadikan instance of object.
 */
inline fun hello2(firstName: String, noinline lastName: () -> String): String {
    return "Hello $firstName ${lastName()}"
}

fun main() {
    println(hello("Adnin", {"Rifandi"}))
    println(hello("Adnin"){"Rifandi"})

    println(hello2("Adnin", {"Rifandi"}))
    println(hello2("Adnin"){"Rifandi"})
}