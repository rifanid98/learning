package kotlin01_fundamental.lesson25_function_varargs_parameter

fun main() {
    /**
     * Bisa memasukkan parameter lebih dari 2
     * padahal kita hanya buat 2 parameter saja.
     *
     * Parameter ke 2 dan selanjutnya disebut
     * varargs parameter. Parameter ke 2 dan
     * selanjutnya akan dijadikan array
     */
    sayHello("Adnin", "Rifandi", "Sutanto")
}

/**
 * Varargs Parameter adalah kemampuan dari Java
 * yang diturunkan ke Kotlin dimana varargs ini
 * bisa menerima inputan lebih dari satu, padahal
 * hanya satu parameter.
 */
fun sayHello(firstName: String, vararg lastName: String) {

    print("Hello $firstName")

    for (name: String in lastName) {
        print("$name ")
    }

    println()
}