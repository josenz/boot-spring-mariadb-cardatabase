// First, we created the 'Owner' entity and repository
//  in the 'domain' package. The 'Owner' entity and 
//  repository are created in a similar way to the 'Car'
//  class. The following is the source code of the 'owner'
//  entity class.

package com.packt.cardatabase.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ownerid;
    private String firstname, lastname;

    // In the owner entity site, the relationship is defined
    //  with the @OneToMany annotation. The type of the field
    //  is 'List<Car>', because the owner may have multiple cars.
    // You can now add the getter and setter for that as follows.

    @OnetoMany(cascade = CascadeType.ALL, mappedBy="owner")
    private List<Car> cars;

    // The @OneToMany annotation has two attributes that we are using.
    // The 'cascade' attribute defines how cascading affects the entities.
    // The 'all' attribute setting means that, if the owner is deleted, the 
    // cars linked to that owner are deleted as well. The 'mappedBy="owner"'
    // attribute setting tells us that the 'car' class has the owner field,
    // which is the foreign key for this relationship.

    public Owner() {}

    public Owner(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getOwnerid() {
        return ownerid;
    }
    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //Getter and setter
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
