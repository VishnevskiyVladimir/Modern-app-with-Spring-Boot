package com.example.springboot.lesson.repository;

import com.example.springboot.lesson.entity.CompanyEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class CompanyRepositoryTest {

    private static final Integer APPLE_ID = 1;
    private static final Integer GOOGLE_ID = 2;

    private static final String APPLE_NAME = "apple";
    private static final String GOOGLE_NAME = "google";

    @Autowired
    CompanyRepository companyRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

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