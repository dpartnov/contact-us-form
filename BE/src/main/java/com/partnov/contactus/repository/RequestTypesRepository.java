package com.partnov.contactus.repository;

import com.partnov.contactus.model.RequestTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestTypesRepository extends JpaRepository<RequestTypes, Long> {
    
}
