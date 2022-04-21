/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package spring_example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_example.model.Person_1;

/**
 *
 * @author Aidyl
 */
@Repository
public interface PersonRepo extends JpaRepository<Person_1, Integer> {

}
