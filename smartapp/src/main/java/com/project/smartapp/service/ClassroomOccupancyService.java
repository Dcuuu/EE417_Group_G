package com.project.smartapp.service;

import com.project.smartapp.entity.ClassroomOccupancy;
import com.project.smartapp.repository.ClassroomOccupancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomOccupancyService {

    @Autowired
    private ClassroomOccupancyRepository classroomOccupancyRepository;

    // Retrieve all classroom occupancy records
    public List<ClassroomOccupancy> getAllOccupancyDetails() {
        return classroomOccupancyRepository.findAll();
    }

	// Create a new classroom occupancy record
    public ClassroomOccupancy addOccupancyRecord(ClassroomOccupancy occupancy) {
        return classroomOccupancyRepository.save(occupancy);
    }

	// Update an existing classroom occupancy record
    public ClassroomOccupancy updateOccupancyRecord(int id, ClassroomOccupancy occupancy) {
        occupancy.setOccupancyId(id);
        return classroomOccupancyRepository.save(occupancy);
    }

	// Delete a classroom occupancy record by ID
    public boolean deleteOccupancyRecord(int id) {
        if (classroomOccupancyRepository.existsById(id)) {
            classroomOccupancyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
