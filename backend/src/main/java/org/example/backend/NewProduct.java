package org.example.backend;

import lombok.With;

@With
public record NewProduct(
    String name,
    int amount
){}
