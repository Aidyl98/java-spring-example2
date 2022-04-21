/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring_example.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring_example.model.Person_1;
import spring_example.repo.PersonRepo;

/**
 *
 * @author Aidyl
 */
@Repository("phpMyAdmin")
public class PersonDataAccessService implements PersonDao_1 {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public int insertPerson(Person_1 person) {
        personRepo.save(person);
        return 1;
    }

    @Override
    public List<Person_1> selectAllPerson() {
        return personRepo.findAll();
    }

    @Override
    public int deletePersonByID(int id) {
        personRepo.deleteById(id);
        return 1;
    }

    @Override /// TODO no funciona
    public int updatePersonByID(int id, Person_1 person) {
        Person_1 personFinal = new Person_1(person.getName());
        personRepo.save(personFinal);
        return 1;
    }

    @Override
    public Optional<Person_1> selectPersonByID(int id) {
        return personRepo.findById(id);
    }

}
