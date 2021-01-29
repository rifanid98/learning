package lesson24_mocking_verification.service

import lesson24_mocking_verification.model.PersonModel
import lesson24_mocking_verification.repository.PersonRepository
import java.lang.IllegalArgumentException
import java.util.*

class PersonService(private val personRepository: PersonRepository) {

    fun get(id: String): PersonModel {
        if (id.isBlank()) {
            throw IllegalArgumentException("Person ID is not valid.")
        }

        val person: PersonModel? = this.personRepository.selectById(id)
        if (person == null) {
            throw Exception("Person not found.")
        }
        return person
    }

    fun register(name: String): PersonModel {
        val id: String = UUID.randomUUID().toString()
        val person: PersonModel = PersonModel(id, name);
        personRepository.insert(person)
        return person
    }

}