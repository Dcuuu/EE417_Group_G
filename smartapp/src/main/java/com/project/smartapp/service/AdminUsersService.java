package com.project.smartapp.service;

import com.project.smartapp.entity.AdminUsers;
import com.project.smartapp.repository.AdminUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUsersService {
    @Autowired
    private AdminUsersRepository adminUsersRepository;

    // Retrieve all admin users records
    public List<AdminUsers> getAllAdminUsers() {
        return adminUsersRepository.findAll();
    }

	// Create a new admin users record
    public AdminUsers addAdminUsers(AdminUsers adminUsers) {
        return adminUsersRepository.save(adminUsers);
    }

	// Update an existing admin users record
    public AdminUsers updateAdminUsers(int id, AdminUsers adminUsers) {
    	adminUsers.setUserId(id);
        return adminUsersRepository.save(adminUsers);
    }

	// Delete an admin users record by ID
    public boolean deleteAdminUsers(int id) {
        if (adminUsersRepository.existsById(id)) {
        	adminUsersRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public AdminUsers findByUsername(String username) {
        return adminUsersRepository.findByUsername(username);
    }
    

}

