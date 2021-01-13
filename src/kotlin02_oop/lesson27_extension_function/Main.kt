package kotlin02_oop.lesson27_extension_function

import kotlin02_oop.lesson17_type_check_casts.divider

// #################################################################
//                       EXTENSION FUNCTION
// #################################################################

/**
 * Extension Function
 *
 * - Pada materi Kotlin Dasar kita sudah membahas tentang Extension
 *   Function, yaitu menambahkan function pada tipe data yang sudah ada.
 * - Ketika membuat extension function, kita tidak mengubah class
 *   atau object yang sudah ada.
 * - Class atau Object yang dibuatkan extension function, bersifat
 *   immutable.
 * - Pada dasarnya ketika membuat extension function, kita membuatnya
 *   diluar class atau object yang bersangkutan sehingga kita tidak
 *   bisa mengakses property dan method yang visibiliy modifiernya
 *   bersifat private & protected.
 *
 * Note
 *
 * - Perlu diperhatikan, bahwa saat membuat extension function, kita
 *   tidak memodifikasi class aslinya.
 * - Extension function hanyalah sebuah function bantuan yang artinya,
 *   kita tidak bisa mengakses data private atau protected dari class
 *   tersebut.
 */
class Student(
    var name: String,
    private var age: Int
) {}

fun Student.sayGoodBye(name: String) {
    println("GoodBye $name, my name is ${this.name}")
    //println("GoodBye $name, my age is ${this.age}") // ERROR. age is private.
}

fun runExtensionFunction() {
    val student: Student = Student("Adnin", 22)
    student.sayGoodBye("Budi")
}

// #################################################################
//                     NULLABLE EXTENSION FUNCTION
// #################################################################

/**
 * Nullable Extension Function
 *
 * - Secara standar, extension function hanya bisa untuk data yang
 *   tidak null.
 * - Jika kita ingin membuat extension function yang bisa digunakan
 *   untuk data yang bisa null, kita perlu menggunakan kata kunci ?
 *   (tanda tanya).
 */
class Student2(
    var name: String,
    private var age: Int
) {}

fun Student2?.sayGoodBye(name: String) {
    if (this != null) {
        println("GoodBye $name, my name is ${this.name}")
        //println("GoodBye $name, my age is ${this.age}") // ERROR. age is private.
    }
}

fun runNullableExtensionFunction() {
    val student2: Student2? = Student2("Adnin", 22)
    student2.sayGoodBye("Budi")
}

fun main() {
    divider("Extension Function", 4)
    runExtensionFunction()

    divider("Nullable Extension Function", 3)
    runNullableExtensionFunction()
}