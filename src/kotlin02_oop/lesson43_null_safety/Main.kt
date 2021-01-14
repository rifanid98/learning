package kotlin02_oop.lesson43_null_safety

import kotlin02_oop.lesson17_type_check_casts.divider

//#################################################################
//                          NULL SAFETY
//#################################################################

/**
 * Null Safety
 *
 * - Jika teman-teman sebelumnya pernah belajar bahasa pemrograman Java,
 *   di Java kita sering mengenal error bernama NullPointerException.
 *   Error ini terjadi ketika kita mengakses properties atau functions
 *   di null object.
 * - Di Kotlin, hal ini sangat jarang terjadi, karena sejak awal di
 *   Kotlin tidak direkomendasikan untuk menggunakan nullable type.
 * - Walaupun akan menggunakan nullable type, di Kotlin kita memberitahu
 *   secara eksplisit menggunakan karakter ? (tanda tanya).
 * - Kali ini kita akan bahas cara-cara agar terhindar dari error null
 *   di Kotlin sehingga tidak sering kejadian seperti di Java.
 */
class Friend(val name: String)

fun sayHello(friend: Friend?): Unit {
    if (friend != null) {
        println("Hello ${friend.name}")
    }
}

fun runNullSafety() {
    sayHello(Friend("Adnin"))
    sayHello(null)
}

//#################################################################
//                        ELVIS OPERATOR
//#################################################################

/**
 * Elvis Operator
 *
 * - Elvis operator hampir sama dengan ternary operator di Java, tapi
 *   dengan kode yang lebih sederhana.
 */
fun sayHello2(friend: Friend?): Unit {
    val name: String = friend?.name ?: "bro"
    println("Hello $name!")
}

fun runElvisOperator() {
    sayHello2(Friend("Adnin"))
    sayHello2(null)
}

//#################################################################
//                        !! OPERATOR
//#################################################################

/**
 * !! Operator
 *
 * - Jika kita sangat mencintai NullPointerException :D.
 * - Dan kita benar-benar yakin bahwa variabel tersebut tidak null.
 * - Maka kita bisa menggunakan kata kunci !! untuk mengkonversi dari
 *   data yang nullable menjadi data tidak nullable.
 * - Tapi ingat, konsekuensinya, jika sampai ternyata datanya null,
 *   maka akan terjadi error.
 */
fun sayHello3(friend: Friend?): Unit {
    val name = friend!!.name
    println("Hello $name")
}

fun runNotOperator() {
    sayHello3(Friend("Adnin"))
    //sayHello3(null) // ERROR. NullPointerException.
}

fun main() {
    divider("Null Safety", 5)
    runNullSafety()

    divider("Elvis Operator", 5)
    runElvisOperator()

    divider("!! Operator", 5)
    runNotOperator()
}