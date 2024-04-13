package com.project.smartapp.entity;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cafeteriamenu")
@Data
public class CafeteriaMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuId;
    private Date date;
    private String mealTime;
    private String menuItems;

    // Constructor, getters, and setters generated from @Data
    
    // Connects to the appropriate table in the database
    // and uses matching variables
}


