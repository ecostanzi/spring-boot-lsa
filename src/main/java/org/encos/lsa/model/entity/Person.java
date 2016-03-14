package org.encos.lsa.model.entity;

import org.encos.lsa.config.StaticConfig;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="PERSON",
        schema = StaticConfig.DB_SCHEMA,
        indexes = {
        @Index(columnList = "USERNAME", name = "PERSON_USERNAME_IDX")
})
public class Person {

    @Id
    @Column(name="ID")
    @GeneratedValue(generator = "pk_sequence", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="pk_sequence", sequenceName = "PERSON_SEQ")
    private Long id;

    @Column(name="USERNAME", length = 20, nullable = false)
    private String userName;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name="FIRST_NAME", length = 50)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name="LAST_NAME", length = 50)
    private String lastName;

    @ManyToOne
    @JoinColumn(name="ADDRESS",
            foreignKey = @ForeignKey(name="fk_person_address")
    )
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

