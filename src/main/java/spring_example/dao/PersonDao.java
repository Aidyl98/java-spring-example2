/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring_example.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import spring_example.model.Person;

/**
 *
 * @author Aidyl
 */
public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPerson();

    int deletePersonByID(UUID id);

    int updatePersonByID(UUID id, Person person);

    Optional<Person> selectPersonByID(UUID id);
}
