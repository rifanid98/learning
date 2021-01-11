package kotlin02_oop.lesson16_any_class

/**
 * Any Class
 *
 * - Di Kotlin, semua class yang kita buat tanpa class Parent, sebenarnya
 *   secara otomatis dia akan menjadi class child dari class Any.
 * - Any adalah superclass untuk semua class yang kita buat di Kotlin.
 */
class Laptop(val name: String): Any()
class Handphone(val name: String) // : Any() otomatis extends Any()
class SmartPhone(val name: String, val os: String)


fun main() {
    println("----- #Handphone")
    val handphone: Handphone = Handphone("Xiaomi")
    println(handphone.toString())

    println("----- #SmartPhone")
    val smartPhone: SmartPhone = SmartPhone("Xiaomi", "Android")
    println(smartPhone.toString())
}