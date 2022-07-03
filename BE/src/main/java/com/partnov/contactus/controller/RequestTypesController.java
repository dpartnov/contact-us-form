package com.partnov.contactus.controller;

import com.partnov.contactus.service.RequestTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requests")
public class RequestTypesController {
    
    @Autowired
    private RequestTypesService service;
    
    @GetMapping()
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
