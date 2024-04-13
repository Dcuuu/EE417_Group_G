package com.project.smartapp.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.smartapp.entity.CafeteriaMenu;
import com.project.smartapp.entity.CafeteriaOccupancy;
import com.project.smartapp.repository.CafeteriaMenuRepository;
import com.project.smartapp.repository.CafeteriaOccupancyRepository;

@Service
public class CafeteriaService {

	@Autowired
	private CafeteriaMenuRepository cafeteriaMenuRepository;

	@Autowired
	private CafeteriaOccupancyRepository cafeteriaOccupancyRepository;

	// Retrieve all cafeteria occupancy records
	public List<CafeteriaOccupancy> getAllOccupancyRecords() {
		return cafeteriaOccupancyRepository.findAll();
	}

	// Retrieve all cafeteria menu items
	public List<CafeteriaMenu> getAllMenuItems() {
		return cafeteriaMenuRepository.findAll();
	}

	// Create a new cafeteria occupancy record
	public CafeteriaOccupancy createOccupancyRecord(CafeteriaOccupancy occupancy) {
		return cafeteriaOccupancyRepository.save(occupancy);
	}

	// Retrieve a cafeteria occupancy record by ID
	public CafeteriaOccupancy getOccupancyRecordById(int id) {
		return cafeteriaOccupancyRepository.findById(id).orElse(null);
	}

	// Update an existing cafeteria occupancy record
	public CafeteriaOccupancy updateOccupancyRecord(CafeteriaOccupancy record) {
		return cafeteriaOccupancyRepository.save(record);
	}

	// Delete a cafeteria occupancy record by ID
	public boolean deleteOccupancyRecord(int id) {
		if (cafeteriaOccupancyRepository.existsById(id)) {
			cafeteriaOccupancyRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	
	 public List<CafeteriaMenu> findMenuByDate(Date date) {
	        // Implement your method to fetch data from the repository based on the date
	        return cafeteriaMenuRepository.findByDate(date);
	    }
	// Add a new cafeteria menu item
	public CafeteriaMenu addMenu(CafeteriaMenu menu) {
        return cafeteriaMenuRepository.save(menu);
    }
	
	// Retrieve a cafeteria menu item by ID
	public Optional<CafeteriaMenu> getMenuById(int id) {
        return cafeteriaMenuRepository.findById(id);
    }
	
	// Delete a cafeteria menu item by ID
	public boolean deleteMenuRecord(int id) {
		if (cafeteriaMenuRepository.existsById(id)) {
			cafeteriaMenuRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	public CafeteriaMenu updateMenu(CafeteriaMenu menu) {
	    return cafeteriaMenuRepository.save(menu);
	}
}
