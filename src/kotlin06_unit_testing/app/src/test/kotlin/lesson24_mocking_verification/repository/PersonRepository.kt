package lesson24_mocking_verification.repository

import lesson24_mocking_verification.model.PersonModel

interface PersonRepository {
    fun selectById(id: String): PersonModel?
    fun insert(personModel: PersonModel)
}