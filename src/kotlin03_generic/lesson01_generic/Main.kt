package kotlin03_generic.lesson01_generic

/**
 * Pengenalan Generic
 *
 * - Generic adalah kemampuan menambahkan parameter type saat membuat
 *   class atau function.
 * - Berbeda dengan parameter type yang biasa kita gunakan di class di
 *   function, generic memungkinkan kita bisa mengubah-ubah bentuk type
 *   sesuai dengan yang kita mau.
 */

/**
 * Manfaat Generic
 *
 * - Pengecekan ketika proses kompilasi.
 * - Tidak perlu manual menggunakan pengecekan tipe data dan konversi tipe
 *   data.
 * - Memudahkan programmer membuat kode program yang generic sehingga bisa
 *   digunakan oleh berbagai tipe data.
 */

/* Bukan Generic */
class Data(val data: Any)

fun runData() {
    val dataString = Data("Eko")
    val valueString: String = dataString.data as String
    println(valueString)

    val dataInt = Data(10)
    val valueInt: Int = dataInt.data as Int
    println(valueInt)
}


/* Generic */
class DataGeneric<T>(val data: T)

fun runDataGeneric() {
    val dataString = DataGeneric<String>("Eko")
    val valueString: String = dataString.data
    println(valueString)

    val dataInt = DataGeneric<Int>(10)
    val valueInt: Int = dataInt.data
    println(valueInt)
}

fun main() {
    divider("Bukan Generic", 5)
    runData()

    divider("Generic", 6)
    runDataGeneric()
}