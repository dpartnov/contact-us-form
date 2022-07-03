package com.partnov.contactus.service;

import com.partnov.contactus.model.RequestTypes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.partnov.contactus.repository.RequestTypesRepository;

/**
 * Service class for working with {@link RequestTypes} data.
 */
@Service
public class RequestTypesService {

    @Autowired
    private RequestTypesRepository requestTypesRepository;

    /*
    * Get all request types from DB.
     */
    public List<RequestTypes> getAll() {
        return requestTypesRepository.findAll();
    }

}
