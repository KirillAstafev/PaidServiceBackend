package com.example.paidservicebackend.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicalRecordIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getMedicalRecordsForPatient() throws Exception {
        var response = mvc.perform(get("/records?patientId={patientId}", 4));

        response.andExpect(status().isOk());
    }
}
