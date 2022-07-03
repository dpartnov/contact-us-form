package com.partnov.contactus.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Entity for REQUESTS table.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "REQUESTS")
public class Requests implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUEST_TYPE_ID")
    private RequestTypes requestType;
    
    @Column(name = "POLICY_NUMBER")
    private String policyNumber;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "SURNAME")
    private String surname;
    
    @Column(name = "MESSAGE")
    private String message;
}
