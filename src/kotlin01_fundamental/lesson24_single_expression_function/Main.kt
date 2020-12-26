package kotlin01_fundamental.lesson24_single_expression_function

fun main() {
    sayHello()
    sayHello("Adnin")
}

/**
 * Single Expression Function adalah deklarasi
 * function yang hanya menggunakan satu baris
 * kode saja
 */
/* SEF with return type */
fun sayHello(name: String): String = "Hello $name!"
/* SEF without return type */
fun sayHello(): Unit = println("Hello Anonymous!")