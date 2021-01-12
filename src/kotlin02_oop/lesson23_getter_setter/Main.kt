package kotlin02_oop.lesson23_getter_setter

/**
 * Getter & Setter
 *
 * - Di bahasa pemrograman Java, ada sebuah konsep yang bernama
 *   Getter dan Setter saat membuat properties.
 * - Getter adalah function yang dibuat untuk mengambil data
 *   properties.
 * - Setter adalah function untuk mengubah data properties.
 * - Di kotlin, kita tidak perlu manual untuk membuat function
 *   Getter dan Setter nya, karena sudah difasilitasi sehingga
 *   lebih mudah.
 */
class Note(title: String) {
    var title: String = title
        /* getter */
        // cara 1
        get() = field
        // cara 2
        /*
         * get() = {
         *  return field
         * }
         */
        /* setter */
        set(value) {
            println("Setter called")
            if (value.isNotBlank()) {
                field = value
            }
        }
}

fun main() {
    val note: Note = Note("Belajar Kotlin")
    println(note.title)
    note.title = "Belajar Kotlin OOP"
    println(note.title)
}