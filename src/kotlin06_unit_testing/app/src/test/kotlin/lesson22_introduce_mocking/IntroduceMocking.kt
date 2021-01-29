package lesson22_introduce_mocking

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito

/**
 * Ketergantungan Antar Class
 *
 * - Saat membuat aplikasi yang besar, source code pun akan semakin besar,
 *   struktur class pun akan semakin kompleks.
 * - Kita tidak bisa memungkiri lagi bahwa akan ada ketergantungan antar class.
 * - Unit test yang bagus itu bisa terprediksi dan cukup nge test ke satu function,
 *   jika harus mengetes interaksi antar class, lebih disarankan integration test.
 * - Lantas bagaimana jika kita harus mengetest class yang ketergantungan dengan
 *   class lain?.
 * - Solusinya adalah melakukan mocking terhadap dependency yang dibutuhkan class
 *   yang akan kita test.
 *
 * Pengenalan Mocking
 *
 * - Mocking sederhananya adalah membuat object tiruan.
 * - Hal ini dilakukan agar behavior object tersebut bisa kita tentukan sesuai
 *   dengan keinginan kita.
 * - Dengan mocking, kita bisa membuat request response seolah-olah object
 *   tersebut benar dibuat.
 *
 * Pengenalan Mockito
 *
 * - Ada banyak framework untuk melakukan mocking, namun di materi ini kita akan
 *   menggunakan Mockito.
 * - Mockito adalah salah satu mocking framework paling populer di Java, dan bisa
 *   digunakan juga untuk Kotlin.
 * - Dan Mockito bisa diintegrasikan baik dengan JUnit.
 * - https://site.mockito.org/.
 */
class IntroduceMocking {

    @Test
    fun mockito() {
        //membuat mock
        val listMock = Mockito.mock(List::class.java) as List<String>
        //menambah behaviour di mock object
        Mockito.`when`(listMock.get(0)).thenReturn("Eko")
        //test mock
        Assertions.assertEquals("Eko", listMock.get(0))
        //verify mock
        Mockito.verify(listMock, Mockito.times(1)).get(0)
    }

}