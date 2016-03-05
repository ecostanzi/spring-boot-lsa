package org.encos.lsa.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="USERNAME")
    private String userName;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name="FIRST_NAME")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name="LAST_NAME")
    private String lastName;

    @ManyToOne
    @JoinColumn(name="ADDRESS")
    private Address address;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

