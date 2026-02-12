package com.kyaw.blog.domain.dto;

import java.util.UUID;

public record CategoryDto(
        UUID id,
        String name,
        Long postCount
) {
}
