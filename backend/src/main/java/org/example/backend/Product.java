package org.example.backend;

import lombok.With;

@With
public record Product(
        String id,
        String name,
        int amount
) {
}
