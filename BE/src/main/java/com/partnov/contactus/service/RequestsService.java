package com.partnov.contactus.service;

import com.partnov.contactus.dto.RequestDto;
import com.partnov.contactus.exception.ValidationException;
import com.partnov.contactus.model.RequestTypes;
import com.partnov.contactus.model.Requests;
import com.partnov.contactus.repository.RequestTypesRepository;
import com.partnov.contactus.repository.RequestsRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for working with {@link Requests} data.
 */
@Service
public class RequestsService {

    @Autowired
    private RequestTypesRepository requestTypesRepository;
    @Autowired
    private RequestsRepository requestsRepository;

    /**
     * Insert new request data to DB.
     * @param requestData input data {@link RequestDto}
     */
    public void createNewRequest(final RequestDto requestData) {
        RequestTypes type = requestTypesRepository.findById(requestData.getRequestTypeId())
                .orElseThrow(() -> new ValidationException("Request type not found"));

        Requests newRequest = new Requests();
        newRequest.setRequestType(type);
        newRequest.setPolicyNumber(requestData.getPolicyNumber());
        newRequest.setName(requestData.getName());
        newRequest.setSurname(requestData.getSurname());
        newRequest.setMessage(requestData.getMessage());
        requestsRepository.save(newRequest);
    }

    /**
     * Get all request from DB.
     * @return List of {@link RequestDto}
     */
    public List<RequestDto> getAllRequests() {
        return requestsRepository.findAll().stream().map(request -> {
            RequestDto dto = new RequestDto();
            dto.setRequestTypeId(request.getRequestType().getId());
            dto.setPolicyNumber(request.getPolicyNumber());
            dto.setName(request.getName());
            dto.setSurname(request.getSurname());
            dto.setMessage(request.getMessage());
            return dto;
        }).collect(Collectors.toList());
    }

}
