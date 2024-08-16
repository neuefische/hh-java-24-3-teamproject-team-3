package org.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductRepository productRepository;

    @Test
    void getAllGroceries() throws Exception {
        //GIVEN
        //WHEN
        mockMvc.perform(MockMvcRequestBuilders.get("/api/products"))

                //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                            []
                        """));
    }
}