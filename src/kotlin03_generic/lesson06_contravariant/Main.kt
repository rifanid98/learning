package kotlin03_generic.lesson06_contravariant

/**
 * Contravariant
 *
 * - Contravariant artinya kita bisa melakukan subtitusi supertype (parent)
 *   dengan subtype (child).
 * - Tidak semua jenis class generic yang mendukung contravariant, hanya
 *   class generic yang menggunakan generic parameter type sebagai parameter
 *   function.
 * - Artinya saat kita membuat object Contoh<Any>, maka bisa disubtitusi
 *   menjadi Contoh<String>.
 * - Untuk memberitahu bahwa generic parameter type tersebut adalah
 *   covariant, kita perlu menggunakan kata kunci in.
 * - Contravariant tidak bisa digunakan untuk return parameter type, tapi
 *   hanya bisa untuk parameter type saja.
 */
class Contravariant<in T> {
    fun sayHello(name: T): Unit {
        println("Hello $name")
    }

    // tidak boleh di contravariant
    //fun data(data: T): T {
    //    return data;
    //}
}

fun main() {
    val contravariantAny: Contravariant<Any> = Contravariant()
    val contravariantString: Contravariant<String> = contravariantAny

    //contravariantString.data() // ERROR. tidak boleh di contravariant
    contravariantString.sayHello("Adnin")
}