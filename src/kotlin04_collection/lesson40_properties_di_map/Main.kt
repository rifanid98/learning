package kotlin04_collection.lesson40_properties_di_map

/**
 * Properties di Map
 *
 * - Salah satu hal yang biasa dilakukan dalam membuat program adalah, menyimpan
 *   value properties di Map.
 * - Kadang ini dilakukan ketika parsing data JSON atau hal-hal dinamis lainnya.
 * - Dalam keadaan seperti ini, kita bisa melakukan delegate properties di Map.
 */
class Application(map: Map<String, Any>) {
    val name: String by map
    val version: Int by map
}

fun main() {
    val applicationProperties: Map<String, Any> = mapOf(
        "name" to "Kotlin App",
        "version" to 1
    )
    val application: Application = Application(applicationProperties)
    println(application.name)
}