/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring_example.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aidyl
 */
@Entity
@Table(name = "person", catalog = "spring", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person_1.findAll", query = "SELECT p FROM Person_1 p"),
    @NamedQuery(name = "Person_1.findById", query = "SELECT p FROM Person_1 p WHERE p.id = :id"),
    @NamedQuery(name = "Person_1.findByName", query = "SELECT p FROM Person_1 p WHERE p.name = :name")})
public class Person_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "name", nullable = false, length = 500)
    private String name;

    public Person_1() {
    }

    public Person_1(Integer id) {
        this.id = id;
    }

    public Person_1(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Person_1(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person_1)) {
            return false;
        }
        Person_1 other = (Person_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "spring_example.model.Person_1[ id=" + id + " ]";
    }
    
}
