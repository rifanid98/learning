package kotlin06_unit_testing

import java.lang.IllegalArgumentException

class Calculator {

    fun add(first: Int, second: Int): Int {
        return first + second
    }

    fun divide(first: Int, second: Int): Int {
        if (second == 0 || first == 0) {
            throw IllegalArgumentException("Tidak bisa dibagi dengan 0")
        }
        return first / second
    }
}