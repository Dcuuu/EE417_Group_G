package com.project.smartapp.entity;

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
@Table(name = "accesslogs")
public class AccessLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AdminUsers adminUsers;

    private String action;
    private Time timestamp;
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Time getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Time timestamp) {
		this.timestamp = timestamp;
	}
	public AdminUsers getAdminUsers() {
	    return adminUsers;
	}
	public void setAdminUsers(AdminUsers adminUsers) {
	    this.adminUsers = adminUsers;
	}


    // Constructor, getters, and setters generated from @Data 
    // Connects to the appropriate table in the database
    // and uses matching variables
}