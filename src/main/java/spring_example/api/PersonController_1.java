/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring_example.api;

import java.util.List;
import java.util.Set;
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
import spring_example.model.Person_1;
import spring_example.service.PersonService_1;

/**
 *
 * @author Aidyl
 */
@RequestMapping("api/v1/person")
@RestController
public class PersonController_1 {

    private static final Validator DEFAULT_VALIDATOR = javax.validation.Validation.buildDefaultValidatorFactory().getValidator();

    private final PersonService_1 personService;

    @Autowired
    public PersonController_1(PersonService_1 personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person_1 person) {
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
    public List<Person_1> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping(path = "{id}")
    public Person_1 getPersonById(@PathVariable("id") int id) {
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonByID(@PathVariable("id") int id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") int id, @RequestBody Person_1 personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }
}
