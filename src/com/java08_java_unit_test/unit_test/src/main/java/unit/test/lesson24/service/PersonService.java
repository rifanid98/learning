package unit.test.lesson24.service;

import unit.test.lesson24.data.Person;
import unit.test.lesson24.repository.PersonRepository;

public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person get(String id) {
        Person person = personRepository.selectById(id);
        if (person == null) {
            throw new IllegalArgumentException("Person not found");
        } else {
            return person;
        }
    }
}
