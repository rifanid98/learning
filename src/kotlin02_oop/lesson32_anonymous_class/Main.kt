package kotlin02_oop.lesson32_anonymous_class

import kotlin02_oop.lesson17_type_check_casts.divider

interface Action {
    fun action(): Unit
}

//#################################################################
//                          NORMAL CLASS
//#################################################################

/* Implement Class Biasa */
class SampleAction: Action {
    override fun action() {
        println("SampleAction")
    }
}

fun fireAction(action: Action) {
    action.action()
}

fun runNormalClass() {
    fireAction(SampleAction())
}

//#################################################################
//                        ANONYMOUS CLASS
//#################################################################

/**
 * Anonymous Class
 *
 * - Saat kita ingin membuat object, maka kita diwajibkan untuk
 *   menggunakan deklarasi class yang  lengkap.
 * - Namun, Kotlin mendukung pembuatan object dari class yang bahkan
 *   belum lengkap.
 * - Bahkan, di Kotlin, kisa bisa membuat object dari interface.
 * - Kemampuan ini dinamakan anonymous class.
 * - Untuk membuat anonymous class, kita bisa menggunakan kata kunci
 *   object diikuti dengan deklarasi class Child seperti pada
 *   pewarisan.
 */
fun runAnonymousClass() {
    fireAction(object : Action {
        override fun action() = println("Action One")
    })

    fireAction(object : Action {
        override fun action() = println("Action Two")
    })
}

fun main() {
    divider("Normal Class", 5)
    runNormalClass()

    divider("Anonymous Class", 5)
    runAnonymousClass()
}