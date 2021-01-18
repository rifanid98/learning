package kotlin03_generic.lesson03_generic_function

/**
 * Generic Function
 *
 * - Generic parameter type tidak hanya bisa digunakan pada class atau
 *   interface.
 * - Kita juga bisa menggunakan generic parameter type di function.
 * - Generic parameter type yang kita deklarasikan di function, hanya
 *   bisa diakses di function tersebut, tidak bisa digunakan di luar
 *   function.
 * - Ini cocok jika kita ingin membuat generic function, tanpa harus
 *   mengubah deklarasi class.
 */
class Function(val name: String) {
    fun <T> sayHello(param: T) {
        println("Hello $param, my name is ${this.name}")
    }
}

fun main() {
    val function = Function("Adnin")

    function.sayHello<String>("Budi")
    function.sayHello("Budi")

    function.sayHello<Int>(22)
    function.sayHello(22)
}
