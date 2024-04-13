package com.project.smartapp.controller;

import com.project.smartapp.entity.LibraryVisitors;
import com.project.smartapp.service.LibraryVisitorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryVisitorsController {
    @Autowired
    private LibraryVisitorsService libraryVisitorsService;

    // Retrieve all library visitors records
    @GetMapping("/visitors")
    public ResponseEntity<List<LibraryVisitors>> getAllLibraryVisitors() {
        List<LibraryVisitors> libraryVisitors = libraryVisitorsService.getAllLibraryVisitors();
        return ResponseEntity.ok(libraryVisitors);
    }

	// Create a new library visitors record
    @PostMapping("/visitors")
    public ResponseEntity<LibraryVisitors> addLibraryVisitor(@RequestBody LibraryVisitors libraryVisitor) {
        LibraryVisitors newLibraryVisitor = libraryVisitorsService.addLibraryVisitor(libraryVisitor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLibraryVisitor);
    }

	// Update an existing library visitors record
    @PutMapping("/visitors/{id}")
    public ResponseEntity<LibraryVisitors> updateLibraryVisitor(@PathVariable int id, @RequestBody LibraryVisitors libraryVisitor) {
        LibraryVisitors updatedLibraryVisitor = libraryVisitorsService.updateLibraryVisitor(id, libraryVisitor);
        if (updatedLibraryVisitor != null) {
            return ResponseEntity.ok(updatedLibraryVisitor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	// Delete a library visitors record by ID
    @DeleteMapping("/visitors/{id}")
    public ResponseEntity<String> deleteLibraryVisitor(@PathVariable int id) {
    	boolean deleted = libraryVisitorsService.deleteLibraryVisitor(id);
        if (deleted) {
            return new ResponseEntity<>("visitor record with ID " + id + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("visitor record with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
    
    
}
