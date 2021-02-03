package part04.lesson34_supervisor_job

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import java.util.concurrent.Executors

class JobSupervisor {

    /**
     * Job
     *
     * - Secara default, saat kita membuat coroutine scope atau menjalankan
     *   coroutine, tipe coroutine tersebut adalah Job.
     * - Dalam Job, saat terjadi error di salah satu coroutine, maka error
     *   tersebut akan di propagate ke parent nya.
     * - Dan secara otomatis parent akan membatalkan semua coroutine.
     */
    @Test
    fun testJob() {
        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope = CoroutineScope(Job() + dispatcher)
        val job1 = scope.launch {
            delay(2000)
            println("Job 1 completed")
        }
        val job2 = scope.launch {
            delay(1000)
            throw IllegalArgumentException("Job 2 failed")
        }
        runBlocking {
            joinAll(job1, job2)
        }
    }

    /**
     * Supervisor Job
     *
     * - SupervisorJob adalah tipe Job lainnya.
     * - Supervisor job bisa menjadikan setiap coroutine memiliki kemampuan untuk
     *   error secara mandiri.
     * - Hal ini berakibat jika ada coroutine error, parent tidak akan membatalkan
     *   seluruh coroutine yang lain.
     */
    @Test
    fun testSupervisorJob() {
        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope = CoroutineScope(SupervisorJob() + dispatcher)
        val job1 = scope.launch {
            delay(2000)
            println("Job 1 complete")
        }
        val job2 = scope.launch {
            delay(1000)
            throw IllegalArgumentException("Job 2 failed")
        }
        runBlocking {
            joinAll(job1, job2)
        }
    }

}