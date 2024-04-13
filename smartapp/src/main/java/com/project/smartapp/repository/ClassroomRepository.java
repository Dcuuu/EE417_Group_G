package com.project.smartapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.smartapp.entity.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

}
