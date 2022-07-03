package com.partnov.contactus.controller;

import com.partnov.contactus.dto.RequestDto;
import com.partnov.contactus.service.RequestsService;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  REST controller for Requests.
 * 
 */
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/requests")
public class RequestsController {

    @Autowired
    private RequestsService service;
    
    /**
     * Get all Request from DB.
     * @return ResponseEntity with List of {@link RequestDto}
     */
    @GetMapping
    public ResponseEntity getAllRequest() {
         return ResponseEntity.ok(service.getAllRequests());
    }

    /**
     * Insert new request data to DB.
     * 
     * @param requestData {@link RequestDto} data
     * @param result BindingResult operation result 
     * @return ResponseEntity with 200 OK, if no errors.
     */
    @PutMapping
    public ResponseEntity createNewRequest(@Valid @RequestBody final RequestDto requestData, final BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList()));
        }

        service.createNewRequest(requestData);
        return ResponseEntity.ok().build();
    }
}
