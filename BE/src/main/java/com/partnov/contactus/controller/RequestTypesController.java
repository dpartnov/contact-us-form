package com.partnov.contactus.controller;

import com.partnov.contactus.service.RequestTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for Request type entity.
 */
@CrossOrigin(origins = "${frontend.url}", maxAge = 3600)
@RestController
@RequestMapping("/requests/types")
public class RequestTypesController {
    
    @Autowired
    private RequestTypesService service;
    
    /**
     * Get all request types.
     * @return  ResponseEntity with List of {@link RequestTypes}
     */
    @GetMapping
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
