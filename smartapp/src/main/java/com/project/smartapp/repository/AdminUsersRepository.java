package com.project.smartapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.smartapp.entity.AdminUsers;

@Repository
public interface AdminUsersRepository extends JpaRepository<AdminUsers, Integer> {
    AdminUsers findByUsername(String username); // Shanshan
}
