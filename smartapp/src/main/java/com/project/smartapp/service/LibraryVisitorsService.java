package com.project.smartapp.service;

import com.project.smartapp.entity.LibraryVisitors;
import com.project.smartapp.repository.LibraryVisitorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryVisitorsService {
    @Autowired
    private LibraryVisitorsRepository libraryVisitorsRepository;

    // Retrieve all library visitors records
    public List<LibraryVisitors> getAllLibraryVisitors() {
        return libraryVisitorsRepository.findAll();
    }

	// Create a new library visitors record
    public LibraryVisitors addLibraryVisitor(LibraryVisitors libraryVisitor) {
        return libraryVisitorsRepository.save(libraryVisitor);
    }

	// Update an existing library visitors record
    public LibraryVisitors updateLibraryVisitor(int id, LibraryVisitors updatedLibraryVisitor) {
        Optional<LibraryVisitors> optionalLibraryVisitor = libraryVisitorsRepository.findById(id);
        if (optionalLibraryVisitor.isPresent()) {
            updatedLibraryVisitor.setLibraryId(id);
            return libraryVisitorsRepository.save(updatedLibraryVisitor);
        } else {
            return null;
        }
    }

	// Delete a library visitors record by ID
    public boolean deleteLibraryVisitor(int id) {
    	if (libraryVisitorsRepository.existsById(id)) {
    		libraryVisitorsRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
