package unit.test.lesson24_mocking_di_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import unit.test.lesson24.data.Person;
import unit.test.lesson24.repository.PersonRepository;
import unit.test.lesson24.service.PersonService;

@Extensions({
    @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    public void setUp() {
        this.personService = new PersonService(personRepository);
    }

    @Test
    public void testNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           personService.get("not found");
        });
    }

    @Test
    public void testGetPersonSuccess() {
        // menambah behaviour ke mock object
        Mockito.when(personRepository.selectById("adnin"))
            .thenReturn(new Person("adnin", "Adnin"));

        var person = personService.get("adnin");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("adnin", person.getId());
        Assertions.assertEquals("Adnin", person.getName());
    }
}
