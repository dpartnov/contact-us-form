package com.partnov.contactus.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO Object for transferring data between BE and FE.
 * Also contains some validations.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    
    @NotNull(message = "Kind of request can not be empty")
    private Long requestTypeId;
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Policy number must be alphanumeric")
    @Size(min = 1, max = 50, message = "Policy number max size is 50 characters")
    private String policyNumber;
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name must be filled in letters only")
    @Size(min = 1, max = 50, message = "Name max size is 50 characters")
    private String name;
    @Pattern(regexp = "^[A-Za-z]+$", message = "Surname must be filled in letters only")
    @Size(min = 1, max = 50, message = "Surname max size is 50 characters")
    private String surname;
    @Size(min = 0, max = 2000, message = "Message max size is 2000 characters")
    private String message;
}
