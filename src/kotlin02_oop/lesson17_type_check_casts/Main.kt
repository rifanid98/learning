package kotlin02_oop.lesson17_type_check_casts

fun divider(title: String, tab: Int = 0) {
    println("\n")
    println("#############################################################")
    for (i in 0..tab) {
        print("\t")
    }
    print("$title\n")
    println("#############################################################")
}

//###############################################################
//                      SAFE CASTS
//###############################################################
/**
 * Type Check & Casts
 *
 * - Dalam Object Oriented Programming, kita akan bertemu dengan
 *   banyak sekali tipe data (class) dan pewarisan (inheritance)
 * - Kadang kita butuh melakukan pengecekan tipe data, atau bahkan
 *   melakukan konversi data
 */
class Laptop()
class HandPhone(val name: String)

fun printObject(any: Any): Unit {
    println(any)
}

fun runPrintObject(): Unit {
    println("----- runPrintObject()")
    printObject("Eko")
    printObject(1)
    printObject(Laptop())
    printObject(HandPhone("Xiaomi"))
    println("\n")
}

/**
 * Type Check
 *
 * - is digunakan untuk melakukan pengecekan apakah sebuah data
 *   merupakan tipe data tertentu.
 * - !is digunakan untuk melakukan pengecekan apakah sebuah data
 *   bukan merupakan tipe data tertentu.
 */
fun printObjectWithTypeCheck(any: Any) {
    /**
     * Smart Casts
     *
     * - Kotlin memiliki mekanisme konversi data secara otomatis
     *   setelah kita melakukan pengecekan menggunakan is.
     * - Setelah kita melakukan pengecekan menggunakan is, maka
     *   secara otomatis tipe data yang kita cek akan berubah
     *   menjadi tipe data yang kita check.
     */
    print("+ Smart Casts with is\t: ")
    if (any is Laptop) {
        println("$any is class Laptop")
    } else if (any is HandPhone) {
        println("$any is class HandPhone and name: ${any.name}")
    } else {
        println(any)
    }

    /**
     * Casts di When Expression
     *
     * - Selain menggunakan If untuk melakukan pengecekan tipe data
     *   dan konversi tipe data.
     * - Kita juga bisa menggunakan when expression.
     * - Penggunaan when expression akan lebih sederhana dibanding
     *   if expression dalam melakukan pengecekan dan konversi tipe data .
     */
    print("- Smart Casts with When\t: ")
    when (any) {
        is Laptop -> println("Laptop $any")
        is HandPhone -> println("HandPhone ${any.name}")
        else -> println(any)
    }
}

fun runPrintObjectWithTypeCheck() {
    println("----- runPrintObjectWithTypeCheck()")
    printObjectWithTypeCheck("Eko")
    printObjectWithTypeCheck(1)
    printObjectWithTypeCheck(Laptop())
    printObjectWithTypeCheck(HandPhone("Xiaomi"))
    println("\n")
}

//###############################################################
//                      UNSAFE CASTS
//###############################################################
/**
 * Unsafe Casts
 *
 * - Kotlin juga mendukung konversi tipe data secara paksa menggunakan kata
 *   kunci as.
 * - Namun konversi menggunakan as sangat tidak aman jika ternyata tipe datanya
 *   tidak sesuai.
 */
fun printString(any: Any): Unit {
    val value = any as String
    println(value)
}

fun runPrintString(): Unit {
    printString("Adnin")
    //printString(1) // ERROR. ClassCastException. Karena castingnya dipaksa.
    println("\n")
}

//###############################################################
//                      SAFE NULLABLE CASTS
//###############################################################
/**
 * Safe Nullable Casts
 *
 * - Penggunaan as sangat tidak aman, namun kadang bisa menjadikannya aman,
 *   dengan menggunakan kata kunci as?.
 * - Dengan menggunakan kata kunci as? secara otomatis jika gagal melakukan
 *   konversi, akan diubah menjadi null.
 */
fun printStringSafeNullable(any: Any): Unit {
    val value: String? = any as? String
    println(value)
}

fun runPrintStringSafeNullable(): Unit {
    printStringSafeNullable("Adnin")
    printStringSafeNullable(1) // NULL
    println("\n")
}

fun main() {
    divider("SAFE CASTS", 5)
    runPrintObject()
    runPrintObjectWithTypeCheck()

    divider("UNSAFE CASTS", 5)
    runPrintString()

    divider("SAFE NULLABLE CASTS",4)
    runPrintStringSafeNullable()
}