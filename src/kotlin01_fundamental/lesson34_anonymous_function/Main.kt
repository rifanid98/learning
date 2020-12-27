package kotlin01_fundamental.lesson34_anonymous_function

/**
 * Anonymous Function
 *
 * - Lambda akan menganggap blok terakhir di blok lambda sebagai hasil kembalian.
 * - Kadang kita butuh membuat lambda yang se flexible function, di mana kita
 *   bisa mengembalikan hasil di manapun. Hal ini kita bisa menggunakan anonymous
 *   function.
 * - Anonymous Function sebenarnya mirip dengan lambda, hanya cara membuatnya saja
 *   yang sedikit berbeda, masih menggunakan kata kunci fun.
 */
fun main() {
    /* Anonymous Function as variable */
    val upper: (String) -> String = fun(string: String): String {
        if (string.isBlank()) {
            return "Ups"
        }
        return string.toUpperCase()
    }

    val lower: (String) -> String = fun(string: String): String {
        if (string.isBlank()) {
            return "Ups"
        }
        return string.toLowerCase()
    }

    println(hello("Adnin", upper))
    println(hello("Adnin", lower))

    /* Anonymous Function as parameter */
    println(hello("Adnin", fun(string: String): String {
        if (string.isBlank()) {
            return "Ups"
        }
        return string.toUpperCase()
    }))
}

fun hello(name: String, stringTransformer: (String) -> String): String {
    return "Hello ${stringTransformer(name)}"
}