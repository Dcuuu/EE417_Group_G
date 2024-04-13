package com.project.smartapp.service;

import com.project.smartapp.entity.ParkingSpot;
import com.project.smartapp.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingSpotService {
    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    // Retrieve all parking spots records
    public List<ParkingSpot> getAllParkingSpots() {
        return parkingSpotRepository.findAll();
    }

	// Create a new parking spots record
    public ParkingSpot addParkingSpot(ParkingSpot parkingSpot) {
        return parkingSpotRepository.save(parkingSpot);
    }

	// Update an existing parking spots record
    public ParkingSpot updateParkingSpot(int id, ParkingSpot updatedParkingSpot) {
        Optional<ParkingSpot> optionalParkingSpot = parkingSpotRepository.findById(id);
        if (optionalParkingSpot.isPresent()) {
            updatedParkingSpot.setSpotId(id);
            return parkingSpotRepository.save(updatedParkingSpot);
        } else {
            return null; // Return null if parking spot with given id is not found
        }
    }

	// Delete a parking spots record by ID
    public boolean deleteParkingSpot(int id) {
    	if (parkingSpotRepository.existsById(id)) {
    		parkingSpotRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
