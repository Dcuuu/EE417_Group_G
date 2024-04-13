package com.project.smartapp.controller;

import com.project.smartapp.entity.AdminUsers;
import com.project.smartapp.service.AdminUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminUsersController {
    @Autowired
    private AdminUsersService adminUsersService;
    
    @PostMapping("/login") // Shanshan
    public ResponseEntity<?> loginAdminUser(@RequestBody AdminUsers loginDetails) {
        AdminUsers user = adminUsersService.findByUsername(loginDetails.getUsername());
        if (user != null && user.getPassword().equals(loginDetails.getPassword())) {
            return ResponseEntity.ok().body(Map.of("success", true, "message", "登录成功"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("success", false, "message", "用户名或密码错误"));
        }
    }
    // Retrieve all admin users records
    @GetMapping("/getusers")
    public ResponseEntity<List<AdminUsers>> getAllAdminUsers() {
        List<AdminUsers> adminUsers = adminUsersService.getAllAdminUsers();
        return ResponseEntity.ok(adminUsers);
    }

	// Create a new admin users record
    @PostMapping("/addusers")
    public ResponseEntity<AdminUsers> addAdminUser(@RequestBody AdminUsers adminUser) {
        AdminUsers newAdminUser = adminUsersService.addAdminUsers(adminUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAdminUser);
    }

	// Update an existing admin users record
    @PutMapping("/updateusers/{id}")
    public ResponseEntity<AdminUsers> updateAdminUser(@PathVariable int id, @RequestBody AdminUsers adminUser) {
        AdminUsers updatedAdminUser = adminUsersService.updateAdminUsers(id, adminUser);
        return ResponseEntity.ok(updatedAdminUser);
    }

	// Delete an admin users record by ID
    @DeleteMapping("/deleteusers/{id}")
    public ResponseEntity<Void> deleteAdminUser(@PathVariable int id) {
        boolean deleted = adminUsersService.deleteAdminUsers(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
