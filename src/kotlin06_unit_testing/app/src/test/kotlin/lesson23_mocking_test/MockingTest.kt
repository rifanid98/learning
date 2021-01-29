package lesson23_mocking_test

import lesson23_mocking_test.model.PersonModel
import lesson23_mocking_test.repository.PersonRepository
import lesson23_mocking_test.service.PersonService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.lang.Exception
import java.lang.IllegalArgumentException

/**
 * Mocking di Test
 *
 * - Mockito memiliki MockitoExtention yang bisa kita gunakan untuk integrasi
 *   dengan JUnit.
 * - Hal ini memudahkan kita ketika ingin membuat mock object, kita cukup gunakan
 *   @Mock.
 * - Agar terbayang bagaimana proses mock, kita akan coba kasus yang lumayan
 *   panjang.
 *
 * Contoh Kasus
 *
 * - Kita punya sebuah class model dengan nama class Person(id: String, name:
 *   String).
 * - Selanjutnya kita punya interface PersonRepository sebagai interaksi ke
 *   database, dan memiliki function selectById(id: String) untuk melakukan
 *   mendapatkan data Person di database.
 * - Dan terakhir kita memiliki class PersonService yang digunakan sebagai class
 *   bisnis logic, dimana di class tersebut kita akan coba gunakan
 *   PersonRepository untuk mendapatkan data dari database, jika gagal, kita akan
 *   throw Exception.
 */
@ExtendWith(MockitoExtension::class)
class MockingTest {

    @Mock
    lateinit var personRepository: PersonRepository
    lateinit var personService: PersonService

    @BeforeEach
    fun beforeEach() {
        personService = PersonService(personRepository)
    }

    @Test
    fun testPersonIDisNotValid() {
        assertThrows<IllegalArgumentException> {
            personService.get("")
        }
    }

    @Test
    fun testNotFound() {
        assertThrows<Exception> {
            personService.get("not found")
        }
    }

    @Test
    fun testGetPersonSuccess() {
        Mockito.`when`(personRepository
            .selectById("adnin"))
            .thenReturn(PersonModel("adnin", "Adnin Rifandi"))

        val person = personService.get("adnin")
        Assertions.assertEquals("adnin", person.id)
        Assertions.assertEquals("Adnin Rifandi", person.name)
    }

}