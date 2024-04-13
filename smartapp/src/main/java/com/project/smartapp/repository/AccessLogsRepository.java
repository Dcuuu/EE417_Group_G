package com.project.smartapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.smartapp.entity.AccessLogs;

@Repository
public interface AccessLogsRepository extends JpaRepository<AccessLogs, Integer> {
}
