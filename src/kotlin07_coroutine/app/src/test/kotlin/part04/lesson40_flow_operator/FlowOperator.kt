package part04.lesson40_flow_operator

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Flow Operator
 *
 * - Flow mirip dengan Kotlin Collection, memiliki banyak operator.
 * - Hampir semua operator yang ada di Kotlin Collection ada juga di Flow,
 *   seperti map, flatMap, filter, reduce, dan lain-lain.
 * - Yang membedakan dengan operator yang ada di Kotlin Collection adalah,
 *   operator di Flow mendukung suspend function.
 */
class FlowOperator {

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
    fun testFlowOperator() {
        runBlocking {
            val flow = numberFlow()
            flow.filter { it % 2 == 0 }
                .map { changeToString(it) }
                .collect { println(it) }
        }
    }

}