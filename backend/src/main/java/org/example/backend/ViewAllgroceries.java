package org.example.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/groceries")
public class ViewAllgroceries {
    @GetMapping
    List<Product> getGroceries(){
        return List.of(new Product("1", "Mango", 3),
                new Product("2", "Avocado", 2));

    }
}
