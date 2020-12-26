package kotlin01_fundamental.lesson21_function_named_argument

fun main() {
    sayHello(firstName = "Adnin", middleName = "Rifandi") // Hello Adnin Rifandi
    sayHello(firstName = "Adnin", middleName = "Rifandi", "Sutanto") // Hello Adnin Rifandi Sutanto
}

/**
 * Function Named Argument
 *
 * Ketika kita membuat sebuah function dengan jumlah
 * parameter yang banyak, kita harus menghafal posisi
 * setiap parameter, sehingga akan menyulitkan.
 *
 * Dengan function named argument, kita hanya perlu
 * memberikan value untuk parameter yang ingin kita
 * gunakan
 */
fun sayHello(firstName: String, middleName: String? = null, lastName: String? = null) {
    if (middleName != null && lastName != null) {
        println("Hello $firstName $middleName $lastName")
    } else if (middleName != null) {
        println("Hello $firstName $middleName")
    } else {
        println("Hello $firstName")
    }
}