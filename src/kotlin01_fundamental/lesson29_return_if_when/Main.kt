package kotlin01_fundamental.lesson29_return_if_when

fun main() {
    val hello1: String = sayHelloIf()
    val hello2: String = sayHelloIf("Adnin")

    println(hello1)
    println(hello2)

    val hello3: String = sayHelloWhen()
    val hello4: String = sayHelloWhen("Rifandi")

    println(hello3)
    println(hello4)
}

/**
 * Return If dan When
 *
 * - Kadang dalam sebuah function, kita sering menggunakan If Expression atau
 *   When Expression, lalu di dalam bloknya kita mengembalikan nilai untuk
 *   sebuah function
 * - Kotlin mendukung Return If atau When, dimana fitur ini bisa mempermudah
 *   kita ketika ingin mengembalikan nilai  dalam if atau when
 */
fun sayHelloIf(name: String = ""): String {
    return if (name.isEmpty()) {
        "Hello Anonymous!"
   } else {
       "Hello $name!"
   }
}

fun sayHelloWhen(name: String = ""): String {
    return when(name) {
        "" -> "Hello Anonymous!"
        else -> "Hello $name"
    }
}