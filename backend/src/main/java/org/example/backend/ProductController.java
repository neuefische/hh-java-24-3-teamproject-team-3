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

    @PostMapping
    public Product saveProduct(@RequestBody NewProduct newProduct) {
        return productService.saveProduct(newProduct);
    }
   @GetMapping("{id}")
    public Product getGroceryProductById(@PathVariable String id){
        return productService.findGroceriesById(id);
   }

}

