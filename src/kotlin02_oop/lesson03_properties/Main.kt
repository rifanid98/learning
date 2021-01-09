package kotlin02_oop.lesson03_properties

/**
 * Properties
 *
 * - Properties / Fields / Attributes adalah data yang bisa kita sisipkan di dalam Object.
 * - Namun sebelum kita bisa memasukkan data di Properties, kita harus mendeklarasikan data
 *   apa aja yang dimiliki object tersebut di dalam deklarasi class-nya.
 * - Membuat Properties sama seperti membuat variable, bisa mutable atau immutable.
 */
class Person {
    // var : mutable
    // val : immutable
    var firstName: String = ""
    var middleName: String? = null
    var lastName: String = ""
}

/**
 * Manipulasi Properties
 *
 * - Properties yang ada di object, bisa kita manipulasi. Tergantung mutable atau immutable.
 * - Jika mutable, berarti kita bisa mengubah data properties nya, namun jika immutable,
 *   kita hanya bisa mengambil data properties nya saja.
 * - Untuk memanipulasi data properties, sama seperti cara pada variable.
 * - Untuk mengakses properties, kita butuh kata kunci . (titik) setelah nama object dan diikuti
 *   nama properties nya.
 */
fun main() {
    // Note: val berarti tidak bisa diubah tipedatanya. Jika tipedatanya object
    // kita masih bisa mengubah value dari objectnya.
    val person: Person = Person()
    // set properties
    person.firstName = "Adnin"
    person.middleName = "Rifandi Sutanto"
    person.lastName = "Putra"
    // get properties
    println(person.firstName)
    println(person.middleName)
    println(person.lastName)
}

