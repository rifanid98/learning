package kotlin02_oop.lesson38_delegation

import kotlin02_oop.lesson17_type_check_casts.divider

/**
 * Delegation
 *
 * - Salah satu design pattern lain yang populer adalah Delegation.
 * - Delegation sederhananya adalah meneruskan properties atau function
 *   ke object yang lain.
 * - Kotlin mendukung delegation tanpa harus membuat kode secara manual.
 */
interface Base {
    fun sayHello(name: String): Unit
}
class MyBase: Base {
    override fun sayHello(name: String): Unit {
        println("Hello $name")
    }
}

/* Delegation Manual */
class MyBaseDelegate(val base: Base): Base {
    override fun sayHello(name: String): Unit {
        base.sayHello(name)
    }
}

fun runDelegationManual() {
    val base: MyBase = MyBase()
    base.sayHello("Adnin")

    val baseDelegate: MyBaseDelegate = MyBaseDelegate(base)
    baseDelegate.sayHello("Adnin")
}

/* Delegation By Kotlin */
class MyBaseDelegateAuto(val base: Base): Base by base

/**
 * Override Delegation
 *
 * - Dalam delegation, properties dan function secara otomatis akan
 *   didelegasikan ke object yang dipilih.
 * - Namun kita tetap bisa meng-override properties dan function jika
 *   kita mau.
 */
class MyBaseDelegateAuto2(val base: Base): Base by base {
    // delegasi manual method sayHello
    override fun sayHello(name: String) {
        // code
    }

    // sisanya di delegasi auto oleh kotlin
}

fun runDelegationAuto() {
    val myBase: MyBase = MyBase()
    val delegate: MyBaseDelegateAuto = MyBaseDelegateAuto(myBase)

    delegate.sayHello("Adnin")
}

fun main() {
    runDelegationManual()
    runDelegationAuto()
}