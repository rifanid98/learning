package part05.lesson41_flow_exception

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Flow Exception
 *
 * - Saat terjadi exception pada flow, di bagian operator apapun, maka flow akan
 *   berhenti, lalu exception akan di throw oleh flow.
 * - Untuk menangkap exception tersebut, kita bisa menggunakan block try-catch.
 * - Namun flow juga menyediakan operator untuk menangkap exception tersebut,
 *   nama functionnya adalah catch().
 * - Dan untuk finally, flow juga sudah menyediakan operatornya, nama function
 *   nya adalah onCompletion().
 * - Ingat, jika terjadi error di flow, flow akan dihentikan, jika kita ingin
 *   flow tidak berhenti saat terjadi error, pastikan kita selalu melakukan try
 *   catch di kode flow nya.
 */
class FlowExceptionTest {

    suspend fun numberFlow(): Flow<Int> {
        return flow {
            repeat(100) {
                emit(it)
            }
        }
    }

    suspend fun changeToString(int: Int): String {
        delay(100)
        return "Number $int"
    }

    @Test
    fun testFlowException() {
        runBlocking {
            val flow = numberFlow()
            flow.map { check(it < 10); it }
                .onEach { println(it) }
                .catch { println("Error ${it.message}") }
                .onCompletion { println("Done") }
                .collect()
        }
    }

}