package kotlin03_generic.lesson02_generic_class

import kotlin03_generic.lesson01_generic.divider

/**
 * Generic Type
 *
 * - Generic type adalah class atau interface yang memiliki parameter
 *   type.
 * - Tidak ada ketentuan dalam pembuatan generic parameter type, namun
 *   biasanya kebanyakan orang menggunakan 1 karakter sebagai generic
 *   parameter type.
 * - Nama generic parameter type yang biasa digunakan adalah :
 *   [+] E - Element (biasa digunakan di collection atau struktur data).
 *   [+] K - Key.
 *   [+] N - Number.
 *   [+] T - Type.
 *   [+] V - Value.
 *   [+] S,U,V etc. - 2nd, 3rd, 4th types.
 */
class MyData<T>(val firstData: T) {

    fun printData(): Unit {
        println("Data is $firstData")
    }

    fun getData(): T {
        return firstData
    }
}

fun runGenericType() {
    val data1: MyData<String> = MyData<String>("Eko")
    val data2: MyData<String> = MyData("Eko")
    val data3 = MyData("Eko")

    data1.printData()
    data2.printData()
    data3.printData()
}

/**
 * Multiple Paramater Type
 *
 * - Parameter type di Generic type boleh lebih dari satu.
 * - Namun harus menggunakan nama type berbeda.
 * - Ini sangat berguna ketika kita ingin membuat generic parameter type
 *   yang banyak.
 */
class MyData2<T, U>(
    val firstData: T,
    val secondData: U
) {

    fun printData(): Unit {
        println("Data is $firstData $secondData")
    }

    fun getSecond(): U {
        return secondData
    }
}

fun runGenericMultipleParameterType() {
    val data1: MyData2<String, Int> = MyData2<String, Int>("Adnin", 22)
    val data2: MyData2<String, Int> = MyData2("Budi", 10)
    val data3 = MyData2("Joko", 18)

    data1.printData()
    data2.printData()
    data3.printData()

    println(data1.getSecond())
    println(data2.getSecond())
    println(data3.getSecond())
}

fun main() {
    divider("Generic Type", 5)
    runGenericType()

    divider("Generic Multiple Parameter Type", 3)
    runGenericMultipleParameterType()
}