/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring_example.api;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_example.model.Person;
import spring_example.service.PersonService;

/**
 *
 * @author Aidyl
 */
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private static final Validator DEFAULT_VALIDATOR = javax.validation.Validation.buildDefaultValidatorFactory().getValidator();

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        validateAndThrow(person);
        personService.addPerson(person);
    }

    public static void validateAndThrow(Object object) throws RuntimeException {
        Set<ConstraintViolation<Object>> errors = DEFAULT_VALIDATOR.validate(object);
        if (!errors.isEmpty()) {
            throw new RuntimeException(errors.iterator().next().getMessage());
        }
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonByID(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }
}
