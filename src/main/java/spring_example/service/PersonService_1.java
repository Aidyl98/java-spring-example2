/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring_example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring_example.dao.PersonDao_1;
import spring_example.model.Person_1;

/**
 *
 * @author Aidyl
 */
@Service
public class PersonService_1 {

    private final PersonDao_1 personDao;

    @Autowired
    public PersonService_1(@Qualifier("phpMyAdmin") PersonDao_1 personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person_1 person) {
        return personDao.insertPerson(person);
    }

    public List<Person_1> getAllPerson() {
        return personDao.selectAllPerson();
    }

    public Optional<Person_1> getPersonById(int id) {
        return personDao.selectPersonByID(id);
    }

    public int deletePerson(int id) {
        return personDao.deletePersonByID(id);
    }

    public int updatePerson(int id, Person_1 newPerson) {
        return personDao.updatePersonByID(id, newPerson);
    }
}
