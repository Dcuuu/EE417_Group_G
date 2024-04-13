package com.project.smartapp.controller;


import com.project.smartapp.entity.AccessLogs;
import com.project.smartapp.service.AccessLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/access-logs")
public class AccessLogsController {
    @Autowired
    private AccessLogsService accessLogsService;

	// Get all access logs records
    @GetMapping("/get-access-logs")
    public ResponseEntity<List<AccessLogs>> getAllAccessLogs() {
        List<AccessLogs> accessLogs = accessLogsService.getAllAccessLogs();
        return ResponseEntity.ok(accessLogs);
    }

	// Create a new access log record
	@PostMapping("/post-access-logs")
    public ResponseEntity<AccessLogs> createAccessLog(@RequestBody AccessLogs accessLogs) {
		AccessLogs newAccessLogs = accessLogsService.addAccessLogs(accessLogs);
        return new ResponseEntity<>(newAccessLogs, HttpStatus.CREATED);
    }
	
	// Update an existing access log record
	@PutMapping("/post-access-logs/{id}")
    public ResponseEntity<AccessLogs> updateAccessLog(@PathVariable int id, @RequestBody AccessLogs updatedAccessLogsRecord) {
		AccessLogs existingAccessLogs = accessLogsService.getAccessLogsById(id);
        if (existingAccessLogs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Update the record with the provided information
        existingAccessLogs.setAdminUsers(updatedAccessLogsRecord.getAdminUsers());
        existingAccessLogs.setAction(updatedAccessLogsRecord.getAction());
        existingAccessLogs.setTimestamp(updatedAccessLogsRecord.getTimestamp());
        AccessLogs updatedAccessLogs = accessLogsService.updateAccessLogs(id, existingAccessLogs);
        return new ResponseEntity<>(updatedAccessLogs, HttpStatus.OK);
    }
    
	// Delete an access log record
	@DeleteMapping("/delete-access-logs/{id}")
    public ResponseEntity<String> deleteAccessLog(@PathVariable int id) {
        boolean deleted = accessLogsService.deleteAccessLogs(id);
        if (deleted) {
            return new ResponseEntity<>("Record with ID " + id + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Record with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
	
}
