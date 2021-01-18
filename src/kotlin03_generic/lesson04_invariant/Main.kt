package kotlin03_generic.lesson04_invariant

/**
 * Invariant
 *
 * - Secara default, saat kita membuat generic parameter type, sifat
 *   parameter tersebut adalah invariant.
 * - Invariant artinya tidak boleh di subtitusi dengan subtype (child)
 *   atau supertype (parent).
 * - Artinya saat kita membuat object Contoh<String>, maka tidak sama
 *   dengan Contoh<Any>, begitupun sebaliknya, saat membuat object
 *   Contoh<Any>, maka tidak sama dengan Contoh<String>.
 */
class Invariant<T>(val data: T)

fun main() {
    val data1: Invariant<String> = Invariant("Adnin")
    //val data2: Invariant<Any> = data1 // ERROR. Invariant
}