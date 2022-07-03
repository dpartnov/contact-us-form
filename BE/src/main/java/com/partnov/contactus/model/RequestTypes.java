package com.partnov.contactus.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Entity for REQUEST_TYPES table.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "REQUEST_TYPES")
public class RequestTypes implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "LABEL")
    private String label;
}