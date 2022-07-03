package com.partnov.contactus.service;

import com.partnov.contactus.model.RequestTypes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.partnov.contactus.repository.RequestTypesRepository;

@Service
public class RequestTypesService {
    
    @Autowired
    private RequestTypesRepository customerRepository;
    
    public List<RequestTypes> getAll() {
        return customerRepository.findAll();
    }
    
}
