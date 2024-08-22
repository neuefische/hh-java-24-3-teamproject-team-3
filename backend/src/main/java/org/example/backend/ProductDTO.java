package org.example.backend;

import lombok.With;

@With
public record ProductDTO(
        String id,
        String name,
        int amount
) {
}
