package kotlin01_fundamental.lesson20_function_default_argument

fun main() {
    sayHello("Adnin")   // Hello Adnin
    sayHello("Adnin", "Rifandi") // Hello Adnin Rifandi
}

/**
 * Function Default Parameter berguna untuk
 * memberikan nilai default pada function
 * parameter, sehingga jika tidak dibutuhkan
 * kita tidak perlu mengisinya karena sudah
 * diberikan nilai defaultnya
 */
fun sayHello(firstName: String, lastName: String? = null) {
    if (lastName != null) {
        println("Hello $firstName")
    } else {
        println("Hello $firstName $lastName")
    }
}