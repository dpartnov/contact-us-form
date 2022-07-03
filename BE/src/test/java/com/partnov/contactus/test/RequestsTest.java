/*
 * Photospot.cz - All rights reserved.
 * 
 */
package com.partnov.contactus.test;

import com.partnov.contactus.dto.RequestDto;
import com.partnov.contactus.starup.StartUpApplication;
import java.net.URI;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Requests tests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartUpApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestsTest {
    private static final String LOCAL_URL = "http://localhost:";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void createNewRequestRestTest() throws Exception {
        RequestDto dto = new RequestDto();
        dto.setRequestTypeId(1L);
        dto.setPolicyNumber("56KLF896");
        dto.setName("Mike");
        dto.setSurname("Testovaci");
        dto.setMessage("Some message....");
        
        //Create new Request
        restTemplate.put(URI.create(LOCAL_URL + port + "/api/v1/requests"), dto);
        //Chek from DB
        assertThat(this.restTemplate.getForObject(LOCAL_URL + port + "/api/v1/requests",
                String.class)).contains("policyNumber\":\"56KLF896\"");
    }
}
