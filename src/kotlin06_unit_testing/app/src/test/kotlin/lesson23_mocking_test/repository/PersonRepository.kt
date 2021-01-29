package lesson23_mocking_test.repository

import lesson23_mocking_test.model.PersonModel

interface PersonRepository {
    fun selectById(id: String): PersonModel?
}