package com.sumutella.departmentcrud.entities;

import javax.persistence.*;

/**
 * @author sumutella
 * @time 10:29 AM
 * @since 11/2/2019, Sat
 */

@Entity
@Table(name = "EMPLOYEES")
public class Manager {
    @Id
    @Column(name = "employee_id")
    @SequenceGenerator(name = "seqEmployee", sequenceName = "employees_seq", allocationSize = 1)
    @GeneratedValue(generator = "seqEmployee", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name="first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;


    public Manager() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
