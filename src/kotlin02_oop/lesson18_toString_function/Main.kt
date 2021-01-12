package kotlin02_oop.lesson18_toString_function

/**
 * toString() Function
 *
 * - toString() adalah function yang digunakan untuk memberitahu
 *   representasi String dari object.
 * - Saat kita melakukan println object, sebenarnya function toString()
 *   akan dipanggil.
 * - Standarnya, function toString() akan mengembalikan referensi
 *   kode unik dari object.
 * - Kita bisa meng-override function toString() jika ingin mengubah representasi
 *   dari String pada object kita.
 */
class User(
    var username: String,
    var password: String
) {
    override fun toString(): String {
        return "User with username=$username"
    }
}

fun main() {
    val user: User = User("root", "root")
    println(user.toString())
}