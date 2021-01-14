package kotlin02_oop.lesson44_exception

import java.lang.Exception
import java.lang.NullPointerException

/**
 * Exception
 *
 * - Saat membuat program, kita pasti akan selalu berhadapan dengan error.
 * - Banyak sekali jenis error, baik itu error yang sudah diduga, seperti
 *   validation error, atau error yang tidak terduga, seperti ada jaringan
 *   error, koneksi ke database error, dan lain-lain.
 * - Error di Kotlin direpresentasikan dengan Exception, dimana semua tipe
 *   data error pasti akan selalu class turunan dari Throwable.
 * - Untuk membuat error di Kotlin sangatlah mudah, kita bisa menggunakan
 *   kata kunci throw, diikuti dengan object error nya.
 */
class ValidationException(message: String): Throwable(message)

fun sayHello(name: String) {
    if (name.isBlank()) {
        throw ValidationException("Name is blank")
    }
    println("Hello $name")
}

fun main() {
    /**
     * Try Catch
     *
     * - Jika dalam program Kotlin kita terjadi exception, maka secara
     *   otomatis program kita akan terhenti.
     * - Kadang kita tidak ingin sampai kejadian seperti itu.
     * - Di Kotlin, kita bisa menangkap exception, lalu melakukan
     *   sesuatu jika terjadi error.
     * - Try Catch di Kotlin digunakan untuk mencoba melakukan sesuatu,
     *   jika terjadi error maka akan ditangkap dan kita bisa memberi
     *   reaksi sesuai dengan yang kita mau.
     */
    try {
        sayHello("Adnin")
        sayHello("")
    } catch (e: ValidationException) {
        println("Error: ${e.localizedMessage}")
    }
    /**
     * Multiple Catch
     *
     * - Saat kita mengeksekusi sebuah kode program di blok Try, bisa
     *   dimungkinan tidak hanya terjadi satu jenis exception, bisa
     *   saja terjadi beberapa jenis exception.
     * - Di Kotlin, kita bisa menggunakan multiple block Catch, untuk
     *   menangkap jenis exception yang berbeda.
     */
    catch (e: NullPointerException) {
        println("Error: Null")
    } catch (e: Exception) {
        println("Error: Unknown Error")
    }
    /**
     * Finally
     *
     * - Finally adalah block kode yang bisa ditambahkan di Try Catch.
     * - Block finally akan selalu dieksekusi setelah kode program Try
     *   Catch di eksekusi, baik itu sukses ataupun gagal.
     * - Ini cocok untuk menempatkan kode yang memang harus dilakukan
     *   tidak peduli baik itu kodenya sukses atau gagal.
     */
    finally {
        println("END trycatch")
    }
}