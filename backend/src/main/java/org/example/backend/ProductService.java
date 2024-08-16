package org.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;


    public List<Product> findAllGroceries(){
        return productRepository.findAll();
    }


}
