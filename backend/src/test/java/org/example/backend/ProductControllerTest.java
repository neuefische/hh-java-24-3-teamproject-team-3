package org.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductRepository productRepository;

    @Test
    @DirtiesContext
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
    @Test
    void deletebyid() throws Exception {
        //Given
        productRepository.save(new Product("2", "banane", 2));
        //When
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/products/2"))
                //Then
                .andExpect(status().isOk());
    }

    @Test
    @DirtiesContext
    void addNewProduct() throws Exception {
        //GIVEN

        //WHEN
      mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
       {
            "name": "Milch",
            "amount": 1
       }
       """))
              //THEN
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Milch"))
                .andExpect(jsonPath("$.amount").value(1));
    }


    @Test
    @DirtiesContext
    void getGroceryProductById() throws Exception {
        //GIVEN
        Product newProduct = new Product("21","apple",24);
        productRepository.save(newProduct);
        //WHEN
        mockMvc.perform(MockMvcRequestBuilders.get("/api/products/21"))
        //THEN
                //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    {
                         "id": "21",
                         "name": "apple",
                         "amount": 24
                         }
                          """));

    }
    }


