package org.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllGroceries() {
        return productService.findAllGroceries();
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable String id) {
        productService.deletebyid(id);
    }}


