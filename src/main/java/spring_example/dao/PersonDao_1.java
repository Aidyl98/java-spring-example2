/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring_example.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import spring_example.model.Person_1;

/**
 *
 * @author Aidyl
 */
public interface PersonDao_1 {

    int insertPerson(Person_1 person);

    List<Person_1> selectAllPerson();

    int deletePersonByID(int id);

    int updatePersonByID(int id, Person_1 person);

    Optional<Person_1> selectPersonByID(int id);
}
