package com.project.smartapp.service;

import com.project.smartapp.dto.ClassroomDTO;
import com.project.smartapp.entity.Classroom;

import com.project.smartapp.repository.ClassroomRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    // Retrieve all classroom records
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

	// Create a new classroom record
    public Classroom addClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

	// Update an existing classroom record
    public Classroom updateClassroom(int id, Classroom classroom) {
        classroom.setClassroomId(id);
        return classroomRepository.save(classroom);
    }

	// Delete a classroom record by ID
    public boolean deleteClassroom(int id) {
        if (classroomRepository.existsById(id)) {
            classroomRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
    public ClassroomDTO getClassroomById(int id) {
        Classroom classroom = classroomRepository.findById(id)
                .orElse(null); // 如果找不到对应ID的教室，则返回null

        if (classroom != null) {
            ClassroomDTO classroomDTO = new ClassroomDTO();
            classroomDTO.setClassroomId(classroom.getClassroomId());
            classroomDTO.setName(classroom.getName());
            classroomDTO.setCapacity(classroom.getCapacity());
            return classroomDTO;
        } else {
            return null; // 如果找不到对应ID的教室，则返回null
        }
    }

}
