package kotlin01_fundamental.lesson19_function_parameter

fun main() {
    /**
     * Function Parameter
     *
     * Parameter di function bisa lebih dari satu,
     * namun ketika menggunakan function parameter,
     * kita harus mengisi value dari parameter yang
     * dibutuhkan
     */
    sayHelloFull("Adnin", "Rifandi")
    sayHello("Adnin", null)
}

fun sayHelloFull(firstName: String, lastName: String) {
    println("Hello $firstName $lastName")
}

/**
 * Dengan parameter yang nullable, kita bisa saja
 * menggunakan hanya parameter yang dibutuhkan
 */
fun sayHello(firstName: String, lastName: String?) {
    if (lastName != null) {
        println("Hello $firstName")
    } else {
        println("Hello $firstName $lastName")
    }
}