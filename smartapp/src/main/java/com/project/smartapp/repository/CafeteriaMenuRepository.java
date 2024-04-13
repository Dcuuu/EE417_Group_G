package com.project.smartapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.sql.Date; // Make sure to import the correct Date class as used in your entity

import com.project.smartapp.entity.CafeteriaMenu;

public interface CafeteriaMenuRepository extends JpaRepository<CafeteriaMenu, Integer> {
    List<CafeteriaMenu> findByDate(Date date); // Method to find menu items by date
}
