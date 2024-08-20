package org.example.backend;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    ProductRepository productRepository = mock(ProductRepository.class);
    ProductService productService = new ProductService(productRepository);

    @Test
    void findAllGroceries() {
    //GIVEN
        Product p1 = new Product("1", "apple", 2);
        Product p2 = new Product("2", "peach",2);
        Product p3 = new Product("3", "banana",3);
        List<Product> products = List.of(p1, p2, p3);

        when(productRepository.findAll()).thenReturn(products);
        //WHEN
        List<Product> actual = productService.findAllGroceries();
        //THEN
        verify(productRepository).findAll();
        assertEquals(products, actual);
    }

    @Test
    void findGroceriesById() {
        //GIVEN
        String id = "4";
        Product product = new Product("4","apple", 7);
        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        //WHEN
        Product actual = productService.findGroceriesById(id);
        //THEN
        verify(productRepository).findById(id);
        assertEquals(product, actual);
    }
}