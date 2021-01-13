package kotlin02_oop.lesson33_enum_class

import kotlin02_oop.lesson17_type_check_casts.divider

/**
 * Enum Class
 *
 * - Enum class merupakan representasi dari class yang sudah tetap
 *   nilainya.
 * - Biasanya enum class digunakan untuk jenis data yang sudah baku,
 *   seperti jenis kelamin, arah mata angin dan sejenisnya.
 * - Untuk membuat enum class, kita bisa menggunakan kata kunci enum
 *   sebelum deklarasi class nya.
 * - Kita tidak bisa membuat object dari class enum, namun kita bisa
 *   mendeklarasikan langsung object yang tersedia untuk enum class
 *   tersebut.
 */
/* Tanpa Properti */
enum class Gender1 {
    MALE,
    FEMALE
}

fun runEnum() {
    val man: Gender1 = Gender1.MALE
    val woman: Gender1 = Gender1.FEMALE
    val all: List<Gender1> = Gender1.values().toList();

    println(man)
    println(woman)
    println(all)
}


/* Dengan Properti */
enum class Gender2(val description: String) {
    MALE("Laki-laki"),
    FEMALE("Perempuan");

    fun showDescription(): Unit {
        println(this.description)
    }
}

fun runEnumProperties() {
    val man: String = Gender2.MALE.description
    val woman: String = Gender2.FEMALE.description
    val all: List<Gender2> = Gender2.values().toList();

    println(man)
    println(woman)
    println(all)
}

fun main() {
    divider("DEFAULT ENUM", 5)
    runEnum()

    divider("ENUM PROPERTIES", 5)
    runEnumProperties()
}
