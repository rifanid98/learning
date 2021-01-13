package kotlin02_oop.lesson24_late_initialized_properties

/**
 * Late-Initialized Properties
 *
 * - Standarnya, properties di Kotlin wajib di inisialisasi di awal
 *   saat deklarasi properties tersebut.
 * - Namun di Kotlin kita juga bisa menunda inisialisasi data para
 *   properties.
 * - Dengan menggunakan kata kunci lateinit, kita bisa membuat
 *   properties tanpa harus langsung mengisi datanya.
 * - Kata kunci lateinit hanya bisa digunakan di var, tidak bisa
 *   digunakan di val.
 */
class Television {
    lateinit var brand: String

    fun initTelevision(name: String) {
        brand = name
    }
}

fun main() {
    val tv: Television = Television()
    //println(tv.brand) // ERROR. Kotlin.UninitializedPropertyAccessException
    /* cara 1 */
    tv.brand = "Samsung"
    /* cara 2 */
    tv.initTelevision("Samsung")
    println(tv.brand)
}