package kotlin01_fundamental.lesson22_unit_returning_function

fun main() {
    sayHello()
    sayHello("Adnin")
}

/**
 * Secara default apabila kita membuat function
 * yang tidak mengembalikan nilai, maka return
 * yang dihasilkan adalah Unit
 */
fun sayHello(name: String? = null): Unit {
    if (name == null) {
        println("Hello Anonymous!")
    } else {
        println("Hello $name")
    }
}