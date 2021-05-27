package com.example.springboot.lesson.repository;

import com.example.springboot.lesson.IntegrationTestBase;
import com.example.springboot.lesson.entity.CompanyEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CompanyRepositoryTest extends IntegrationTestBase {

    private static final Integer APPLE_ID = 1;
    private static final Integer GOOGLE_ID = 2;

    private static final String APPLE_NAME = "apple";
    private static final String GOOGLE_NAME = "google";

    @Autowired
    CompanyRepository companyRepository;

    @Test
    void getByIdTest() {
        var companyInDB = companyRepository.findById(APPLE_ID);
        assertTrue(companyInDB.isPresent());
        companyInDB.ifPresent(company -> assertEquals(APPLE_NAME, company.getName()));
    }

    @Test
    void saveTest() {
        CompanyEntity company = CompanyEntity.builder()
                .name("Fitbit")
                .build();
        companyRepository.save(company);
        assertNotNull(company.getId());
    }
}