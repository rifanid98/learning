package kotlin02_oop.lesson20_hashcode_function

import kotlin02_oop.lesson17_type_check_casts.divider

/**
 * HashCode Function
 *
 * - hashCode adalah function yang digunakan sebagai representasi
 *   angka unit untuk objek yang kita buat.
 * - Function hashCode sangat berguna saat kita ingin mengkonversi
 *   objek kita menjadi angka.
 * - Salah satu penggunaan hashCode yang banyak dilakukan adalah di
 *   struktur data, misal untuk memastikan tidak ada data duplicate,
 *   agar lebih mudah, di cek nilai hashCode nya, jika hashCode
 *   sama, maka dianggap objectnya sama.
 */
class Company(var name: String) {}

/* Menggunakan equals() default */
fun defaultHashCode() {
    val company1: Company = Company("HP")
    val company2: Company = Company("HP")
    println(company1.hashCode() == company2.hashCode()) // false
    println("\n")
}

class NashTa(var name: String) {

    override fun hashCode(): Int {
        return name.hashCode();
    }

}

/* Menggunakan equals() override */
fun overrideHashCode() {
    val nashta1: NashTa = NashTa("HP")
    val nashta2: NashTa = NashTa("HP")
    println(nashta1.hashCode() == nashta2.hashCode()) // false
    println("\n")
}

fun main() {
    divider("DEFAULT EQUALS", 3)
    defaultHashCode()

    divider("OVERRIDE EQUALS", 3)
    overrideHashCode()
}