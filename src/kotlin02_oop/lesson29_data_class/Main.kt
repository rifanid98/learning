package kotlin02_oop.lesson29_data_class

import kotlin02_oop.lesson17_type_check_casts.divider

// #################################################################
//                            DATA CLASS
// #################################################################

/**
 * Data Class
 *
 * - Kadang kita sering membuat class yang hanya digunakan sebagai
 *   representasi dari data.
 * - Data Class cocok digunakan dalam hal ini.
 * - Data Class merupakan class yang secara otomatis akan membuatkan
 *   function equals, hashCode, toString dan copy dari semua properties
 *   yang terdapat di primary constructors yang dimiliki oleh data
 *   class.
 */
data class Product(
    val name: String,
    val price: Int,
    val category: String
)

fun runDataClass() {
    val product: Product = Product(
        "Indomie",
        2_500,
        "Food"
    )
    println(product)
    println(product.hashCode())
    println(product.equals(product))
}

// #################################################################
//                          COPY DATA CLASS
// #################################################################

/**
 * Copy Data Class
 *
 * - Data class memiliki function copy yang bisa digunakan untuk
 *   menduplikasi object.
 * - Bahkan metode copy yang terdapat di data class bisa digunakan
 *   untuk menduplikasi sekaligus mengubah properties nya.
 */
data class Product1(
    val name: String,
    val price: Int,
    val category: String
)

fun runCopyDataClass() {
    val product1: Product1 = Product1(
        "Indomie",
        2_500,
        "Food"
    )

    /* copy class */
    println("----- copy class")
    val product2: Product1 = product1.copy()
    println(product2)
    println(product2.hashCode())
    println(product2.equals(product1))

    println("\n")

    /* copy class with parameter */
    println("----- copy class with parameter")
    val product3: Product1 = product1.copy(name = "Supermie")
    println(product3)
    println(product3.hashCode())
    println(product3.equals(product2))
}

fun main() {
    divider("DATA CLASS", 5)
    runDataClass()

    divider("COPY DATA CLASS", 4)
    runCopyDataClass()
}