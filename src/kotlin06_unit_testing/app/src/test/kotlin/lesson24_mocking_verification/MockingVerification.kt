package lesson24_mocking_verification

import lesson24_mocking_verification.model.PersonModel
import lesson24_mocking_verification.repository.PersonRepository
import lesson24_mocking_verification.service.PersonService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

/**
 * Verifikasi di Mocking
 *
 * - Pada materi sebelumnya, kita tidak melakukan verifikasi terhadap object
 *   mocking, apakah dipanggil atau tidak.
 * - Pada kasus sebelumnya mungkin tidak terlalu berguna karena kebetulan function
 *   nya mengembalikan value, sehingga kalo kita lupa memanggil function nya,
 *   sudah pasti unit test nya gagal.
 * - Lantas bagaimana jika function nya tidak mengembalikan value? Alias function
 *   unit.
 *
 * Contoh Kasus
 *
 * - Kita akan melanjutkan kasus sebelumnya.
 * - Di interface PersonRepository kita akan membuat function insert(person:
 *   Person) yang digunakan untuk menyimpan data ke database, namun tidak
 *   mengembalikan value, alias unit.
 * - Di class PersonService kita akan membuat function register(name: String)
 *   dimana akan membuat object Person dengan id random, lalu menyimpan ke
 *   database via PersonRepository, lalu mengembalikan object person tersebut.
 */
@ExtendWith(MockitoExtension::class)
class MockingVerification {

    @Mock
    lateinit var personRepository: PersonRepository
    lateinit var personService: PersonService

    @BeforeEach
    fun beforeEach() {
        personService = PersonService(personRepository)
    }

    /**
     * Ini salah.
     * Kenapa salah?
     *
     * - Coba hapus kode personRepository.insert(person).
     * - Maka unit test nya pun tetap sukses.
     * - Hal ini terjadi karena, kita tidak melakukan verifikasi bahwa mocking
     *   object dipanggil.
     * - Hal ini sangat berbahaya, karena jika code sampai naik ke production,
     *   bisa jadi orang yag registrasi datanya tidak masuk ke database.
     */
    @Test
    fun testCreateSuccess1() {
        val person: PersonModel = personService.register("Adnin")
        Assertions.assertEquals("Adnin", person.name)
        Assertions.assertNotNull(person.id)
    }

    /**
     * Ini benar.
     * Kenapa benar?
     *
     * - Karena dilakukan verifikasi mockito apakah object yang dimock itu
     *   dipanggil atau tidak.
     */
    @Test
    fun testCreateSuccess2() {
        val person: PersonModel = personService.register("Adnin")
        Assertions.assertEquals("Adnin", person.name)
        Assertions.assertNotNull(person.id)

        // verifikasi bahwa object yang dimock yaitu personRepository dengan
        // method insert() apakah dipanggil atau tidak.
        Mockito.verify(personRepository,
            Mockito
            .times(1))
            .insert(PersonModel(person.id, person.name)
        )
    }

}