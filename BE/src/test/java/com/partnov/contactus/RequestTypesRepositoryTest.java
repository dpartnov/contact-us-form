package com.partnov.contactus;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.partnov.contactus.repository.RequestTypesRepository;
import com.partnov.contactus.starup.StartUpApplication;
import java.util.Arrays;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartUpApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class RequestTypesRepositoryTest {
    private static final String LOCAL_URL = "http://localhost:";
    
    @Autowired
    private RequestTypesRepository requestTypesRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void requestTypesDbDataTest() {
        assertThat(requestTypesRepository.findAll().size()).isEqualTo(3);
    }

    @Test
    public void requestTypesRestTest() throws Exception {
        assertThat(this.restTemplate.getForObject(LOCAL_URL + port + "/api/v1/requests/",
                String.class)).contains(Arrays.asList("Contract Adjustment", "Damage Case", "Complaint"));
    }

}
