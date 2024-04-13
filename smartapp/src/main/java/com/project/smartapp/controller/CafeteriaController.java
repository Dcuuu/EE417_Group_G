package com.project.smartapp.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.smartapp.entity.CafeteriaMenu;
import com.project.smartapp.entity.CafeteriaOccupancy;
import com.project.smartapp.service.CafeteriaService;

@RestController
@RequestMapping("/cafeteria")
public class CafeteriaController {
    
	@Autowired
    private CafeteriaService cafeteriaService;

	// Get all cafeteria occupancy records
	@GetMapping("/records")
    public ResponseEntity<List<CafeteriaOccupancy>> getAllOccupancyRecords() {
        List<CafeteriaOccupancy> occupancyRecords = cafeteriaService.getAllOccupancyRecords();
        return ResponseEntity.ok(occupancyRecords);
    }
	
	// Create a new cafeteria occupancy record
	@PostMapping("/post-records")
    public ResponseEntity<CafeteriaOccupancy> createOccupancyRecord(@RequestBody CafeteriaOccupancy occupancy) {
        CafeteriaOccupancy newOccupancy = cafeteriaService.createOccupancyRecord(occupancy);
        return new ResponseEntity<>(newOccupancy, HttpStatus.CREATED);
    }
	
	// Update an existing cafeteria occupancy record
	@PutMapping("/post-records/{id}")
    public ResponseEntity<CafeteriaOccupancy> updateOccupancyRecord(@PathVariable int id, @RequestBody CafeteriaOccupancy updatedRecord) {
        CafeteriaOccupancy existingRecord = cafeteriaService.getOccupancyRecordById(id);
        if (existingRecord == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Update the record with the provided information
        existingRecord.setDate(updatedRecord.getDate());
        existingRecord.setTime(updatedRecord.getTime());
        existingRecord.setCurrentOccupancy(updatedRecord.getCurrentOccupancy());
        CafeteriaOccupancy updatedOccupancy = cafeteriaService.updateOccupancyRecord(existingRecord);
        return new ResponseEntity<>(updatedOccupancy, HttpStatus.OK);
    }
	
	// Delete a cafeteria occupancy record
	@DeleteMapping("/delete-records/{id}")
    public ResponseEntity<String> deleteOccupancyRecord(@PathVariable int id) {
        boolean deleted = cafeteriaService.deleteOccupancyRecord(id);
        if (deleted) {
            return new ResponseEntity<>("Record with ID " + id + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Record with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping("/get-all-items") //Shanshan
	public ResponseEntity<List<CafeteriaMenu>> getAllMenuItems() {
	    List<CafeteriaMenu> menuItems = cafeteriaService.getAllMenuItems();
	    return ResponseEntity.ok(menuItems);
	}
	 
	@GetMapping("/getMenuById/{id}") //Shanshan
	public ResponseEntity<CafeteriaMenu> getMenuById(@PathVariable int id) {
	    Optional<CafeteriaMenu> menu = cafeteriaService.getMenuById(id);
	    if (menu.isPresent()) {
	        return ResponseEntity.ok(menu.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	// Add a new cafeteria menu
	@PostMapping("/addMenu")
    public ResponseEntity<CafeteriaMenu> addMenu(@RequestBody CafeteriaMenu menu) {
        CafeteriaMenu savedMenu = cafeteriaService.addMenu(menu);
        return new ResponseEntity<>(savedMenu, HttpStatus.CREATED);
    }
	
	 @GetMapping("/get-items")
	    public List<CafeteriaMenu> getMenuItemsByDate(@RequestParam("date") Date date) {
	        return cafeteriaService.findMenuByDate(date);
	    }
    
	
	// Update an existing cafeteria menu
		@PutMapping("/updateMenu/{id}")
	    public ResponseEntity<String> updateMenu(@PathVariable int id, @RequestBody CafeteriaMenu menu) {
	        Optional<CafeteriaMenu> existingMenu = cafeteriaService.getMenuById(id);
	        if (existingMenu.isPresent()) {
	            menu.setMenuId(id);
	            cafeteriaService.updateMenu(menu);
	            return ResponseEntity.ok("Menu updated successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Menu not found with id: " + id);
	        }
	    }
	
	// Delete a cafeteria menu
	@DeleteMapping("/deleteMenu/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable int id) {
		boolean deleted = cafeteriaService.deleteMenuRecord(id);
        if (deleted) {
            return new ResponseEntity<>("Record with ID " + id + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Record with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
