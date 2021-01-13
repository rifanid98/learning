package kotlin02_oop.lesson39_lazy_properties

/**
 * Lazy Properties
 *
 * - Selain delegating di class, Kotlin mendukung delegating di
 *   properties. Namun materi ini tidak akan dibahas disini, karena
 *   butuh mengerti dahulu tentang Generic Programming. Materi
 *   Delagating di Properties akan dibahas di series Kotlin Generic.
 * - Salah satu implementasi delegating properties yang sudah
 *   disediakan oleh Kotlin adalah, lazy properties.
 * - Lazy adalah standar library yang telah disediakan agar properties
 *   baru diinisialisasi ketika properties itu diakses.
 */
class Lazy {
    val name: String by lazy {
        println("Lazy Call")
        "Eko"
    }
}

fun main() {
    val lazy: Lazy = Lazy()
    println(lazy.name)
    println(lazy.name)
    println(lazy.name)
}