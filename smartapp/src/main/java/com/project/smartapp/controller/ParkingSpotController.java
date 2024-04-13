package com.project.smartapp.controller;

import com.project.smartapp.entity.ParkingSpot;
import com.project.smartapp.service.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingSpotController {
    @Autowired
    private ParkingSpotService parkingSpotService;

    // Retrieve all parking spots records
    @GetMapping("/getSpots")
    public ResponseEntity<List<ParkingSpot>> getAllParkingSpots() {
        List<ParkingSpot> parkingSpots = parkingSpotService.getAllParkingSpots();
        return ResponseEntity.ok(parkingSpots);
    }

	// Create a new parking spots record
    @PostMapping("/addSpots")
    public ResponseEntity<ParkingSpot> addParkingSpot(@RequestBody ParkingSpot parkingSpot) {
        ParkingSpot newParkingSpot = parkingSpotService.addParkingSpot(parkingSpot);
        return ResponseEntity.status(HttpStatus.CREATED).body(newParkingSpot);
    }

	// Update an existing parking spots record
    @PutMapping("/updateSpots/{id}")
    public ResponseEntity<ParkingSpot> updateParkingSpot(@PathVariable int id, @RequestBody ParkingSpot parkingSpot) {
        ParkingSpot updatedParkingSpot = parkingSpotService.updateParkingSpot(id, parkingSpot);
        if (updatedParkingSpot != null) {
            return ResponseEntity.ok(updatedParkingSpot);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	// Delete a parking spots record by ID
    @DeleteMapping("/DeleteSpots/{id}")
    public ResponseEntity<String> deleteParkingSpot(@PathVariable int id) {
    	boolean deleted = parkingSpotService.deleteParkingSpot(id);
        if (deleted) {
            return new ResponseEntity<>("parkingspot record with ID " + id + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("parkingspot record with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
