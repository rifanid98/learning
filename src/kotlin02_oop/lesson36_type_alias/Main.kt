package kotlin02_oop.lesson36_type_alias

/**
 * Type Alias
 *
 * - Kotlin mendukung Type Alias.
 * - Type Alias adalah membuat nama berbeda dari tipe data yang telah
 *   ada.
 * - Biasanya ini digunakan ketika ada tipe data dengan nama yang sama,
 *   atau untuk mempersingkat tipe data sehingga kita tidak perlu menulisnya terlalu panjang.
 */
/* typealias tipe data */
typealias Setring = String
typealias Nomer = Int

/* typealias lambda function */
typealias Supplier = () -> String
fun sayHello(supplier: Supplier) {
    println("Hello ${supplier()}")
}

/* typealias class */
class Student(var name: String)
typealias Pelajar = Student

fun main() {
    val name: Setring = "Adnin"
    val age: Nomer = 22

    val murid: Pelajar = Pelajar("Adnin")
    val siswi: Pelajar = Pelajar("Ninda")

    sayHello { "Adnin" }
}

typealias Siswa = Student
