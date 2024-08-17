package org.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;


    public List<Product> findAllGroceries(){
        return productRepository.findAll();
    }


    public Product findGroceriesById(String id) {
     return productRepository.findById(id)
             .orElseThrow(() -> new NoSuchElementException("Product with id: " + id + " not found!"));
    }
}
