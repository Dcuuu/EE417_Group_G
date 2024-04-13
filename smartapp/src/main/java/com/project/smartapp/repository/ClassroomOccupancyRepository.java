package com.project.smartapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.smartapp.entity.ClassroomOccupancy;

@Repository
public interface ClassroomOccupancyRepository extends JpaRepository<ClassroomOccupancy, Integer> {
    // Add custom query methods if needed
}
