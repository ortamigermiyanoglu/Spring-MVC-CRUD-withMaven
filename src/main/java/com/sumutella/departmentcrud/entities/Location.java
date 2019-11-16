package com.sumutella.departmentcrud.entities;

import javax.persistence.*;

/**
 * @author sumutella
 * @time 10:30 AM
 * @since 11/2/2019, Sat
 */

@Entity
@Table(name = "LOCATIONS")
public class Location {

    @Id
    @Column(name = "location_id")
    @SequenceGenerator(name = "seqLocation", sequenceName = "locations_seq", allocationSize = 100)
    @GeneratedValue(generator = "seqLocation", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String city;

    public Location() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
