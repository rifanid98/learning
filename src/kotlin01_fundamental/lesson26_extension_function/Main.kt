package kotlin01_fundamental.lesson26_extension_function

fun main() {
    sayHello()
}

fun sayHello() {
    var name: String = "Adnin"
    var hello: String = name.hello()
    println(hello)
}

/**
 * Extension Function
 *
 * Extension function adalah kemampuan menambahkan
 * function pada tipe data yang sudah ada
 */
fun String.hello(): String {
    return "Hello $this"
}