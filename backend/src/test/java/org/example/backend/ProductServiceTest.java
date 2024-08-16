package org.example.backend;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    private final ProductRepository mockProductRepo = mock(ProductRepository.class);
    private final ProductService productService = new ProductService(mockProductRepo);
    @Test
    void findAll() {
        //given
        List<Product> expected = List.of();
        //when
        when(mockProductRepo.findAll()).thenReturn(expected);
        List<Product> actual = productService.findAll();
        verify(mockProductRepo).findAll();
        //then
        assertEquals(expected, actual);
    }
}