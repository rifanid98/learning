package unit.test.lesson24.repository;

import unit.test.lesson24.data.Person;

public interface PersonRepository {

    Person selectById(String id);
}
