package kotlin02_oop.lesson15_super_constructor

/**
 * Super Constructor
 *
 * - Kata kunci super tidak hanya bisa digunakan untuk mengakses function atau properties di
 *   class Parent.
 * - Kata kunci super juga bisa digunakan untuk mengakses constructor class Parent.
 * - Mengakses constructor class Parent hanya bisa dilakukan di dalam constructor class Child.
 */
/* Parent Class */
open class Customer(
    // Primary Constructor
    val name: String,
    val type: String,
    val balance: Long
) {
    /* Secondary Constructor */
    constructor(name: String, type: String): this(name, type, 0L)
    constructor(name: String): this(name, "Standard")
}

/* Child Class */
class PremiumCustomer: Customer {
    constructor(name: String): super(name, "Premium")
    constructor(name: String, balance: Long): super(name, "Premium", balance)
}

/* Child Class with Primary Constructor */
class ExecutiveCustomer(
    name: String,
    balance: Long
): Customer(name, "Executive", balance) {
    constructor(name: String): this(name, 0)
}

fun main() {
    val premiumCustomer: PremiumCustomer = PremiumCustomer("Adnin")
    println(premiumCustomer.name)

    val executiveCustomer: ExecutiveCustomer = ExecutiveCustomer("Rifandi", 1_000_000)
    println(executiveCustomer.name)
    println(executiveCustomer.balance)
}