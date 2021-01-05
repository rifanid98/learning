package unit.test.service;

import unit.test.data.Person;
import unit.test.repository.PersonRepository;

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
