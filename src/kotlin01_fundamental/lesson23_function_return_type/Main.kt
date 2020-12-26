package kotlin01_fundamental.lesson23_function_return_type

fun main() {
    val hello1: String = sayHello()
    val hello2: String = sayHello("Adnin")

    println(hello1)
    println(hello2)

    println(sumNumber(100, 100))
    println(sumNumber(number1 = 100, number2 = 100))
}

/**
 * Function Return Type
 *
 * Ketika kita membuat function dengan return
 * type, maka kita harus mengembalikan nilai
 * dari function tersebut sesuai dengan type
 * data yang diminta untuk dikembalikan
 *
 * Return Type yang didukung adalah semua tipe
 * data yang ada di kotlin seperti Int, String,
 * Unit, Float, Double etc.
 */
fun sayHello(name: String? = null): String {
    if (name == null) {
        /* Mengembalikan nilai String */
        return "Hello Anonymous!"
    } else {
        /* Mengembalikan nilai String */
        return "Hello $name!"
    }
}

fun sumNumber(number1: Int, number2: Int): Int {
    return number1 + number2
}