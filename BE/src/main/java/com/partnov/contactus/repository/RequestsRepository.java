package com.partnov.contactus.repository;

import com.partnov.contactus.model.Requests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Repository for {@link Requests} entity.
 */
@Repository
public interface RequestsRepository extends JpaRepository<Requests, Long> {
    
}
