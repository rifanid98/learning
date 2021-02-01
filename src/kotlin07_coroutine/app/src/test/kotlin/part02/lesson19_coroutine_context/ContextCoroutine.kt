package part02.lesson19_coroutine_context

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.coroutines.CoroutineContext

/**
 * Coroutine Context
 *
 * - Coroutine selalu berjalan dibarengi dengan object CoroutineContext.
 * - CoroutineContext adalah sebuah kumpulan data CoroutineContext.Element, yang
 *   paling utama contohnya adalah Job (turunan dari CoroutineContext.Element) dan
 *   CoroutineDispatcher (yang akan dibahas di materi tersendiri).
 */
class ContextCoroutine {

    @ExperimentalStdlibApi
    @Test
    fun testContext() {
        runBlocking {
            val job = GlobalScope.launch {
                val context: CoroutineContext = this.coroutineContext
                println(context)
                println(context[Job])
                println(context[CoroutineDispatcher])

                val job: Job? = context[Job]
                job?.cancel()
            }
            job.join()
        }
    }

}