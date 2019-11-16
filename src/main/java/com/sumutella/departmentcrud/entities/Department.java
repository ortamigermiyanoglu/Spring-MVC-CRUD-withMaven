package com.sumutella.departmentcrud.entities;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


/**
 * @author sumutella
 * @time 10:31 AM
 * @since 11/2/2019, Sat
 */



@Entity
@Table(name = "DEPARTMENTS")
public class Department {


    @Id
    @Column(name = "DEPARTMENT_ID")
    @SequenceGenerator(name = "seqDepartment", sequenceName = "departments_seq", allocationSize = 10)
    @GeneratedValue(generator = "seqDepartment", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "Department names must be non empty")
    @Length(min = 2, message = "Department names must be at least 2 characters")
    @Column(name = "DEPARTMENT_NAME", nullable = false, unique = true)
    private String departmentName;

    @Column(name = "MANAGER_ID")
    private Integer managerId;
    @Column(name = "LOCATION_ID")
    private Integer locationId;

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", managerId=" + managerId +
                ", locationId=" + locationId +
                '}';
    }
}
