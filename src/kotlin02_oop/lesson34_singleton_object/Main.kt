package kotlin02_oop.lesson34_singleton_object

import kotlin02_oop.lesson17_type_check_casts.divider

//#################################################################
//                        SINGLETON OBJECT
//#################################################################

/**
 * Singleton Object
 *
 * - Salah satu konsep Design Pattern yang sangat populer adalah
 *   singleton object.
 * - Singleton object adalah object yang hanya dibuat satu kali.
 * - Di Kotlin, membuat object singleton sangat mudah, hanya dengan
 *   menggunakan kata kunci object.
 * - Cara membuat singleton object di Kotlin sama seperti membuat
 *   class.
 * - Singleton object mirip dengan class, bisa extends class ataupun
 *   interface.
 * - Namun singleton object tidak memiliki constructors.
 */
object Utilities {
    var name: String = "Utilities"
    fun toUpper(value: String): String {
        return value.toUpperCase()
    }
}

fun a() {
    println(Utilities.name)
}

fun b() {
    println(Utilities.name)
}

fun runSingletonObject() {
    println(Utilities.toUpper("Adnin Rifandi"))
    println(Utilities.toUpper("Sutanto Putra"))

    println(Utilities.name)
    // ketika properti diubah
    Utilities.name = "Berubah"
    // semuanya berubah
    a()
    b()
}

//#################################################################
//                      SINGLETON INNER OBJECT
//#################################################################

/**
 * Singleton Inner Object
 *
 * - Di Kotlin, singleton object bisa dibuat di dalam sebuah class.
 * - Namun berbeda dengan inner class, singleton object tidak bisa
 *   mengakses properties atau function yang ada di outer class nya.
 */
class Application(val name: String) {
    object Utilities {
        fun toUpper(value: String): String {
            return value.toUpperCase()
        }
    }
}

fun runSingletonInnerObject() {
    println(Application.Utilities.toUpper("Adnin Rifandi Sutanto Putra"))
}

fun main() {
    divider("Singleton Object", 5)
    runSingletonObject()

    divider("Singleton Inner Object", 4)
    runSingletonInnerObject()
}
