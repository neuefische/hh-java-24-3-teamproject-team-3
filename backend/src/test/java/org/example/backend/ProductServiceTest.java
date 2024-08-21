package org.example.backend;

import org.junit.jupiter.api.Test;

import java.util.List;

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
    void deleteProduct_Test() {
        doNothing().when(productRepository).deleteById("2");
        productService.deletebyid("2");
        verify(productRepository).deleteById("2");
    }
}