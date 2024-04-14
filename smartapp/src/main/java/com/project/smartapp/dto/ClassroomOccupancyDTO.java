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
	public int getOccupancyId() {
		return occupancyId;
	}
	public void setOccupancyId(int occupancyId) {
		this.occupancyId = occupancyId;
	}
	public int getClassroomId() {
		return classroomId;
	}
	public void setClassroomId(int classroomId) {
		this.classroomId = classroomId;
	}
	public String getClassroomName() {
		return classroomName;
	}
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
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
}
