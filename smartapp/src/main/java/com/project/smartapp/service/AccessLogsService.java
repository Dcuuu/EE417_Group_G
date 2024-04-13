package com.project.smartapp.service;

import com.project.smartapp.entity.AccessLogs;
import com.project.smartapp.repository.AccessLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessLogsService {
    @Autowired
    private AccessLogsRepository accessLogsRepository;

    // Retrieve all access logs records
    public List<AccessLogs> getAllAccessLogs() {
        return accessLogsRepository.findAll();
    }

	// Create a new access logs record
    public AccessLogs addAccessLogs(AccessLogs accessLogs) {
        return accessLogsRepository.save(accessLogs);
    }

	// Update an existing access logs record
    public AccessLogs updateAccessLogs(int id, AccessLogs accessLogs) {
    	accessLogsRepository.findById(id);
        return accessLogsRepository.save(accessLogs);
    }

	// Delete an access logs record by ID
    public boolean deleteAccessLogs(int id) {
        if (accessLogsRepository.existsById(id)) {
        	accessLogsRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
