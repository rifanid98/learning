package kotlin03_generic.lesson08_type_projection

/**
 * Type Projection
 *
 * - Kadang agak sulit untuk membuat class generic type yang harus
 *   covariant atau contravariant, misal karena memang di class generic
 *   tersebut terdapat input dan output generic parameter type.
 * - Namun jika kita membuat function untuk memanipulasi data invariant
 *   sangat lah sulit, karena generic parameter type nya harus selalu sama.
 * - Kita bisa melakukan type projection, yaitu menambahkan informasi
 *   covariant atau contravariant di parameter function, ini memaksa isi
 *   function untuk melakukan pengecekan.
 * - Jika covariant, kita tidak boleh mengubah data generic di object.
 * - Jika contravariant, kita tidak boleh ngambil data generic object.
 */
class Container<T>(var data: T)

fun copy(from: Container<out Any>, to: Container<in Any>) {
    to.data = from.data
}

fun main() {
    val data1: Container<String> = Container("Data 1")
    val data2: Container<Any>    = Container("Data 2")
    copy(data1, data2)
    println(data1.data)
    println(data2.data)
}