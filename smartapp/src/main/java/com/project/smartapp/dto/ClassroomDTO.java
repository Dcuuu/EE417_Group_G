package com.project.smartapp.dto;

import lombok.Data;

//Constructor, getters, and setters generated from @Data
@Data
public class ClassroomDTO {
    private int classroomId;
    private String name;
    private int capacity;
	public int getClassroomId() {
		return classroomId;
	}
	public void setClassroomId(int classroomId) {
		this.classroomId = classroomId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
