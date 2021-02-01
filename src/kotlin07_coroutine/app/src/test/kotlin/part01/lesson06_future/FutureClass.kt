package part01.lesson06_future

import org.junit.jupiter.api.Test
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.system.measureTimeMillis

/**
 * Callable
 *
 * - Sebelumnya kita sudah tau, bahwa Thread akan mengeksekusi isi method run yang
 *   ada di interface Runnable, hanya saja masalahnya, return value dari Runnable
 *   adalah void (unit), artinya tidak mengembalikan data.
 * - Jika kita ingin mengeksekusi sebuah kode yang mengembalikan data, kita bisa
 *   menggunakan interface Callable, dimana terdapat method call dan return value
 *   nya adalah generic.
 * - Kita bisa menggunakan ExecutorService.submit(callable) untuk mengeksekusi
 *   Callable, dan hasilnya adalah sebuah Future<T>.
 *
 * Future
 *
 * - Future merupakan return value untuk eksekusi Callable.
 * - Dengan Future, kita bisa mengecek status apakah proses telah selesai, atau
 *   bisa mendapatkan data hasil return callable, atau bahkan membatalkan proses
 *   callable yang sedang berjalan.
 */
class FutureClass {

    val executorService = Executors.newFixedThreadPool(10)

    fun getFoo(): Int {
        Thread.sleep(1000)
        return 10
    }

    fun getBar(): Int {
        Thread.sleep(1000)
        return 10
    }

    @Test
    fun testNonParallel() {
        val time = measureTimeMillis {
            val foo = getFoo()
            val bar = getBar()
            val result = foo + bar
            println(result)
        }
        println("Total time: $time")
    }

    @Test
    fun testFutureGet() {
        val time = measureTimeMillis {
            val foo: Future<Int> = executorService.submit(Callable { getFoo() })
            val bar: Future<Int> = executorService.submit(Callable { getBar() })
            val result = foo.get() + bar.get()
            println(result)
        }

        println("Total time: $time")
    }
}