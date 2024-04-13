package com.project.smartapp.dto;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

// Constructor, getters, and setters generated from @Data
@Data
public class ClassroomOccupancyDTO {
    private int occupancyId;
    private int classroomId;
    private String classroomName;
    private int capacity;
    private Date date;
    private Time time;
    private boolean occupied;
}
