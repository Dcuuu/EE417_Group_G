package com.project.smartapp.controller;

import com.project.smartapp.dto.ClassroomDTO;
import com.project.smartapp.dto.ClassroomOccupancyDTO;
import com.project.smartapp.entity.Classroom;
import com.project.smartapp.entity.ClassroomOccupancy;
import com.project.smartapp.service.ClassroomService;
import com.project.smartapp.service.ClassroomOccupancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private ClassroomOccupancyService classroomOccupancyService;

    // Get all classrooms
    @GetMapping("/get_all")
    public ResponseEntity<List<ClassroomDTO>> getAllClassrooms() {
        List<ClassroomDTO> classroomDTOs = classroomService.getAllClassrooms().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(classroomDTOs);
    }
 // Shanshan
    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDTO> getClassroomById(@PathVariable int id) {
        ClassroomDTO classroomDTO = classroomService.getClassroomById(id);
        if (classroomDTO != null) {
            return ResponseEntity.ok(classroomDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Create a new classroom
    @PostMapping("/add-class")
    public ResponseEntity<ClassroomDTO> addClassroom(@RequestBody ClassroomDTO classroomDTO) {
        Classroom classroom = convertToEntity(classroomDTO);
        Classroom savedClassroom = classroomService.addClassroom(classroom);
        return new ResponseEntity<>(convertToDTO(savedClassroom), HttpStatus.CREATED);
    }

    // Update an existing classroom
    @PutMapping("/update-class/{id}")
    public ResponseEntity<ClassroomDTO> updateClassroom(@PathVariable int id, @RequestBody ClassroomDTO classroomDTO) {
        Classroom classroom = convertToEntity(classroomDTO);
        Classroom updatedClassroom = classroomService.updateClassroom(id, classroom);
        return ResponseEntity.ok(convertToDTO(updatedClassroom));
    }

    // Delete a classroom
    @DeleteMapping("/delete-class/{id}")
    public ResponseEntity<String> deleteClassroom(@PathVariable int id) {
        boolean deleted = classroomService.deleteClassroom(id);
        if (deleted) {
            return new ResponseEntity<>("Classroom with ID " + id + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Classroom with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    // Helper method to convert Classroom entity to DTO
    private ClassroomDTO convertToDTO(Classroom classroom) {
        ClassroomDTO dto = new ClassroomDTO();
        dto.setClassroomId(classroom.getClassroomId());
        dto.setName(classroom.getName());
        dto.setCapacity(classroom.getCapacity());
        return dto;
    }

    // Helper method to convert DTO to Classroom entity
    private Classroom convertToEntity(ClassroomDTO classroomDTO) {
        Classroom classroom = new Classroom();
        classroom.setClassroomId(classroomDTO.getClassroomId());
        classroom.setName(classroomDTO.getName());
        classroom.setCapacity(classroomDTO.getCapacity());
        return classroom;
    }

    // Get all classroom occupancy details
    @GetMapping("/occupancy-details")
    public ResponseEntity<List<ClassroomOccupancyDTO>> getAllOccupancyDetails() {
        List<ClassroomOccupancyDTO> occupancyDTOs = classroomOccupancyService.getAllOccupancyDetails().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(occupancyDTOs);
    }

    // Add a new classroom occupancy record
    @PostMapping("/occupancy/add")
    public ResponseEntity<ClassroomOccupancyDTO> addOccupancyRecord(@RequestBody ClassroomOccupancyDTO occupancyDTO) {
        ClassroomOccupancy occupancy = convertToEntity(occupancyDTO);
        ClassroomOccupancy savedOccupancy = classroomOccupancyService.addOccupancyRecord(occupancy);
        return new ResponseEntity<>(convertToDTO(savedOccupancy), HttpStatus.CREATED);
    }

    // Update an existing classroom occupancy record
    @PutMapping("/occupancy/update/{id}")
    public ResponseEntity<ClassroomOccupancyDTO> updateOccupancyRecord(@PathVariable int id, @RequestBody ClassroomOccupancyDTO occupancyDTO) {
        ClassroomOccupancy occupancy = convertToEntity(occupancyDTO);
        ClassroomOccupancy updatedOccupancy = classroomOccupancyService.updateOccupancyRecord(id, occupancy);
        return ResponseEntity.ok(convertToDTO(updatedOccupancy));
    }

    // Delete a classroom occupancy record
    @DeleteMapping("/occupancy/delete/{id}")
    public ResponseEntity<String> deleteOccupancyRecord(@PathVariable int id) {
        boolean deleted = classroomOccupancyService.deleteOccupancyRecord(id);
        if (deleted) {
            return new ResponseEntity<>("Occupancy record with ID " + id + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Occupancy record with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    // Helper method to convert ClassroomOccupancy entity to DTO
    private ClassroomOccupancyDTO convertToDTO(ClassroomOccupancy occupancy) {
        ClassroomOccupancyDTO dto = new ClassroomOccupancyDTO();
        dto.setOccupancyId(occupancy.getOccupancyId());
        dto.setClassroomId(occupancy.getClassroom().getClassroomId());
        dto.setClassroomName(occupancy.getClassroom().getName());
        dto.setCapacity(occupancy.getClassroom().getCapacity());
        dto.setDate(occupancy.getDate());
        dto.setTime(occupancy.getTime());
        dto.setOccupied(occupancy.isOccupied());
        return dto;
    }

    // Helper method to convert DTO to ClassroomOccupancy entity
    private ClassroomOccupancy convertToEntity(ClassroomOccupancyDTO occupancyDTO) {
        ClassroomOccupancy occupancy = new ClassroomOccupancy();
        occupancy.setOccupancyId(occupancyDTO.getOccupancyId());
        Classroom classroom = new Classroom();
        classroom.setClassroomId(occupancyDTO.getClassroomId());
        classroom.setName(occupancyDTO.getClassroomName());
        classroom.setCapacity(occupancyDTO.getCapacity());
        occupancy.setClassroom(classroom);
        occupancy.setDate(occupancyDTO.getDate());
        occupancy.setTime(occupancyDTO.getTime());
        occupancy.setOccupied(occupancyDTO.isOccupied());
        return occupancy;
    }
}
