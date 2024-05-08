/*
 * You can use the following import statements
 *
 * import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 * 
 * import javax.persistence.*;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.eventmanagementsystem.model;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;
import com.example.eventmanagementsystem.model.Event;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "sponsor")
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "industry")
    private String industry;

    @ManyToMany(mappedBy = "sponsors")
    @JsonIgnoreProperties("sponsors")
    private List<Event> events = new ArrayList<>();

    public Sponsor() {
    }

    public Sponsor(int id, String name, String industry, List<Event> events) {
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.events = events;
    }

    public int getSponsorId() {
        return this.id;
    }

    public void setSponsorId(int id) {
        this.id = id;
    }

    public String getSponsorName() {
        return this.name;
    }

    public void setSponsorName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return this.industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}