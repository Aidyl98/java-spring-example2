/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring_example.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring_example.dao.PersonDao;
import spring_example.model.Person;

/**
 *
 * @author Aidyl
 */
@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPerson() {
        return personDao.selectAllPerson();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.selectPersonByID(id);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePersonByID(id);
    }

    public int updatePerson(UUID id, Person newPerson) {
        return personDao.updatePersonByID(id, newPerson);
    }
}
