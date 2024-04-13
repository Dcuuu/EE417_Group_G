package com.project.smartapp.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "classroomoccupancy")
public class ClassroomOccupancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int occupancyId;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    private Date date;
    private Time time;
    private boolean occupied;

    // Constructor, getters, and setters generated from @Data
    
    // Connects to the appropriate table in the database
    // and uses matching variables
}