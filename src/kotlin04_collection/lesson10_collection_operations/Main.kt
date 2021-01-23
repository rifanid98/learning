package kotlin04_collection.lesson10_collection_operations

/**
 * Collection Operations
 *
 * - Kotlin sudah menyediakan berbagai macam operation yang bisa kita
 *   lakukan di collection.
 * - Sebelumnya kita sudah bahas banyak sekali operasi yang tersedia
 *   sebagai function bawaan collection.
 * - Kotlin juga menyediakan operations tambahan berubah extension
 *   function.
 * - Collection operations berupa extension function selalu menghasilkan
 *   collection baru, tanpa mengubah data di collection aslinya.
 * - Oleh karena itu, collection operations di Kotlin sangat aman ketika
 *   dilakukan karena tidak akan mengubah collection aslinya.
 */
const val collectionOperations = ""
/**
 * Jenis Operations
 *
 * - Transformations, melakukan transformasi terhadap collection.
 * - Filtering, melakukan filtering atau seleksi terhadap collection.
 * - plus and minus operators, operasi + dan - terhadap collection.
 * - Grouping, melakukan pemisahan dalam group terhadap collection.
 * - Retrieving collection parts, mengambil sebagian data di collection.
 * - Retrieving single elements, mengambil satu data di collection.
 * - Ordering, melakukan pengurutan data di collection.
 * - Aggregate operations, melakukan agregasi terhadap data yang ada di
 *   collection.
 */
fun main() {
    listOf<String>("Adnin", "Rifandi").forEach { value -> println(value) }
    listOf<String>("Adnin", "Rifandi").forEachIndexed { index, item ->
        println("$index = $item")
    }
}