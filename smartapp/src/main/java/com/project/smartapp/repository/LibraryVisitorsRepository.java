package com.project.smartapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.smartapp.entity.LibraryVisitors;

@Repository
public interface LibraryVisitorsRepository extends JpaRepository<LibraryVisitors, Integer> {
}
