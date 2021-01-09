package kotlin02_oop.lesson02_object

/**
 * Object
 * - Membuat Object di Kotlin sangat mudah, mirip seperti memanggil function,
 *   dengan menggunakan nama class.
 * - Di Kotlin, tidak butuh kata kunci khusus untuk membuat Object, misal jika
 *   di Java kita butuh menggunakan kata kunci new untuk membuat Object.
 */
class Person

fun main() {
    val eko: Person = Person()
    val joko: Person = Person()
    val budi: Person = Person()

    println(eko)
    println(joko)
    println(budi)
}