package kotlin02_oop.lesson06_secondary_constructor

/**
 * Secondary Constructor
 *
 * - Kotlin mendukung pembuatan constructor lebih dari satu.
 * - Constructor yang utama yang terdapat di Class, disebut primary constructor,
 *   constructor tambahan yang bisa kita buat lagi adalah secondary constructor.
 * - Saat membuat constructor, kita wajib memanggil primary constructor jika ada
 *   primary constructor.
 *
 * Intermezzo
 *
 * - Secondary Constructor di Kotlin bisa kita sebut sebagai
 *   constructor overloading seperti di Java.
 */
/* Cara 1 */
class Person (
    // Primary Constructor
    firstName: String = "",
    middleName: String? = null,
    lastName: String = ""
) {
    /**
     * Constructor Overloading
     */
    constructor(firstName: String, lastName: String):
    this(firstName, null, lastName) {

    }

    var firstName: String = firstName
    var middleName: String? = middleName
    var lastName: String = lastName
}

/* Cara 2 */
class Hooman {
    var firstName: String = ""
    var middleName: String? = null
    var lastName: String = ""

    /**
     * Langsung menggunakan Secondary Constructor tanpa membuat
     * Primary Constructor terlebih dahulu. Gaya penulisan ini
     * mirip seperti membuat Constructor di Java dan di bahasa
     * pemrograman yang lain.
     */
    constructor(firstName: String, lastName: String) {
        this.firstName = firstName
        this.lastName = lastName
    }

    /**
     * Constructor Overloading
     *
     * Kita masih bisa menjadikan Secondary Constructor lainnya
     * menjadi seperti layaknya Primary Constructor. Yaitu memanggilnya
     * dengan menggunakan this() seperti memanggil Primary Constructor
     * yang asli. Namun ini sifatnya opsional, tidak diwajibkan.
     *
     * Constoh menggunakan this()
     */
    constructor(firstName: String, middleName: String?, lastName: String)
            : this(firstName, lastName) {
        // kita tidak meng-assign properti firstName dan lastName.
        // karena hal itu sudah dihandle oleh Primary Constructor
        // buatan yang sudah dibuat di atas.
        this.middleName = middleName
    }
}

fun main() {
    /* Menggunakan Primary Constructor */
    val person1: Person = Person(
        "Adnin",
        "Rifandi Sutanto",
        "Putra"
    )
    println("----- #Person1")
    println(person1.firstName)
    println(person1.middleName)
    println(person1.lastName)

    /* Menggunakan Secondary Constructor */
    val person2: Person = Person(
        "Adnin",
        "Rifandi"
    )
    println("----- #Person1")
    println(person2.firstName)
    println(person2.middleName)
    println(person2.lastName)

    /**
     * Menggunakan Primary Constructor Buatan
     */
    /* Menggunakan Primary Constructor Buatan (Secondary Constructor 1) */
    val hooman1: Hooman = Hooman(
        "Adnin Rifandi",
        "Sutanto Putra"
    )
    println("----- #Hooman1")
    println(hooman1.firstName)
    println(hooman1.middleName)
    println(hooman1.lastName)

    /* Menggunakan Secondary Constructor (Secondary Constructor 2) */
    val hooman2: Hooman = Hooman(
        "Adnin",
        "Rifandi Sutanto",
        "Putra"
    )
    println("----- #Hooman1")
    println(hooman2.firstName)
    println(hooman2.middleName)
    println(hooman2.lastName)
}