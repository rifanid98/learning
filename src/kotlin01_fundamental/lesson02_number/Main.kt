package kotlin01_fundamental.lesson02_number

fun main() {
    /** Data Type in Kotlin */
    numbers()
    floats()
    literals()
    conversions()
}

fun numbers() {
    /** Number Data Type */
    var byte: Byte = 30
    var int: Int = 170
    var short: Short = 2000
    var long: Long = 1_000_000_000L
}

fun floats() {
    /** Float */
    var float: Float = 98.98F
    var doble: Double = 2342342343.54535
}

fun literals() {
    /** Literals */
    var decimalLiteral: Int = 100
    var hexadecimalLiteral: Int = 0xFF
    var binaryLiteral: Int = 0b0001
}

fun conversions() {
    /**
     * Number Conversion
     *
     * Tipe data yang tidak mampu menampung nilai dari
     * tipe data sebelumnya, maka akan terjadi overflow
     * (valuenya ter-reset atau muter-muter sesuai max
     * kapasitas dari tipe datanya)
     */
    var long: Long = 1_000_000_000L

    var byte: Byte = long.toByte()
    var short: Short = long.toShort()
    var int: Int = long.toInt()
    var float: Float = long.toFloat()
    var double: Double = long.toDouble()
}
