package org.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.NoSuchElementException;


@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public void deletebyid(String id) {
        productRepository.deleteById(id);
    }


    public List<Product> findAllGroceries(){
        return productRepository.findAll();
    }


    public Product findGroceriesById(String id) {
     return productRepository.findById(id)
             .orElseThrow(() -> new NoSuchElementException("Product with id: " + id + " not found!"));
    }
    public Product updateProduct(ProductDTO updateProduct, String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException(("No product found with id: " + id)))
                .withName(updateProduct.name())
                .withAmount(updateProduct.amount());
        return productRepository.save(product);
    }


}
