package lesson23_mocking_test.service

import lesson23_mocking_test.model.PersonModel
import lesson23_mocking_test.repository.PersonRepository
import java.lang.IllegalArgumentException

class PersonService(private val personRepository: PersonRepository) {

    fun get(id: String): PersonModel {
        if (id.isBlank()) {
            throw IllegalArgumentException("Person ID is not valid.")
        }

        val person = this.personRepository.selectById(id)
        if (person == null) {
            throw Exception("Person not found.")
        }
        return person
    }

}