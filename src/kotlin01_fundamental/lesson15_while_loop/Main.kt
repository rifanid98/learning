package kotlin01_fundamental.lesson15_while_loop

fun main() {
    /**
     * While loop adalah perulangan berdasarkan
     * kondisi dari suatu argumen. Kita harus
     * menentukan kapan while berhenti loop
     * ketika suatu kondisi terntentu pada argumen
     */
    var i: Int = 0
    while (i < 10) { // while akan berhenti ketika argumen ini false
        println(i)
        i++; // ini yang membuat argumennya bisa menjadi false
    }
}