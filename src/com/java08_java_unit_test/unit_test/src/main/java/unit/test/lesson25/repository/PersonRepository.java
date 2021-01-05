package unit.test.lesson25.repository;

import unit.test.lesson25.data.Person;

public interface PersonRepository {

    Person selectById(String id);
    void insert(Person person);
}
