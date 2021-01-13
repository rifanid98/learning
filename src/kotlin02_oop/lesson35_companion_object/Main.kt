package kotlin02_oop.lesson35_companion_object

/**
 * Companion Object
 *
 * - Companion object adalah kemampuan membuat inner object di dalam
 *   class, tanpa harus menggunakan nama object.
 * - Companion object secara otomatis akan menggunakan nama Companion,
 *   atau bisa langsung diakses lewat nama class nya.
 * - Companion object cocok digunakan ketika ingin membuat inner object
 *   dengan nama yang sama dengan outer classnya.
 */
class Application(val name: String) {
    companion object {
        fun hello(name: String): Unit {
            println("Hello $name")
        }

        fun toUpper(name: String): Unit {
            println(name.toUpperCase())
        }
    }
}

fun main() {
    Application.hello("Adnin Rifandi")
    Application.Companion.hello("Adnin Rifandi")

    Application.toUpper("Adnin Rifandi")
    Application.Companion.toUpper("Adnin Rifandi")
}