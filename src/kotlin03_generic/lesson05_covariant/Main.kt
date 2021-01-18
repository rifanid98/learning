package kotlin03_generic.lesson05_covariant

/**
 * Covariant
 *
 * - Covariant artinya kita bisa melakukan subtitusi subtype (child) dengan
 *   supertype (parent).
 * - Tidak semua jenis class generic yang mendukung covariant, hanya class
 *   generic yang menggunakan generic parameter type sebagai return type
 *   function.
 * - Artinya saat kita membuat object Contoh<String>, maka bisa disubtitusi
 *   menjadi Contoh<Any>.
 * - Untuk memberitahu bahwa generic parameter type tersebut adalah
 *   covariant, kita perlu menggunakan kata kunci out.
 * - Covariant tidak bisa digunakan untuk parameter type, tapi hanya bisa
 *   untuk return parameter type saja.
 * - Covariant hanya boleh menggunakan val, tidak bisa menggunakan var.
 */
class Covariant<out T>(val data: T) {
    fun data(): T {
        return data
    }
}

fun main() {
    val covariantString: Covariant<String> = Covariant("Adnin")
    val covariantAny: Covariant<Any> = covariantString

    println(covariantAny.data())
}
