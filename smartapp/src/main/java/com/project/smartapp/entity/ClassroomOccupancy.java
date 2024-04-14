package com.project.smartapp.entity;

import java.sql.Date;
import java.sql.Time;

import com.project.smartapp.dto.ClassroomDTO;

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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	public void setOccupancyId(int id) {
	    this.occupancyId = id;
	}
	public int getOccupancyId() {
	    return this.occupancyId;
	}
	public ClassroomDTO getClassroom() {
	    ClassroomDTO classroomDTO = new ClassroomDTO();
	    classroomDTO.setClassroomId(this.classroom.getClassroomId());
	    return classroomDTO;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}


    // Constructor, getters, and setters generated from @Data
    
    // Connects to the appropriate table in the database
    // and uses matching variables
}