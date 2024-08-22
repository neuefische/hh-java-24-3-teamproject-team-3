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
    public Product AddProduct(@RequestBody NewProduct newProduct) {
        return productService.saveProduct(newProduct);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable String id) {
        productService.deletebyid(id);
    }

   @GetMapping("{id}")
    public Product getGroceryProductById(@PathVariable String id){
        return productService.findGroceriesById(id);
   }

}

