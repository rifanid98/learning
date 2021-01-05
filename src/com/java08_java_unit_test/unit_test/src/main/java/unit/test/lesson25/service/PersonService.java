package unit.test.lesson25.service;

import unit.test.lesson25.data.Person;
import unit.test.lesson25.repository.PersonRepository;

import java.util.UUID;

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

    public Person register(String name) {
        var person = new Person(UUID.randomUUID().toString(), name);
        /* apabila personRepository tidak dipanggil, maka
           akan gagal. apabila dipanggil lebih dari sekali
           maka akan gagal juga */
        personRepository.insert(person);
        return person;
    }
}
