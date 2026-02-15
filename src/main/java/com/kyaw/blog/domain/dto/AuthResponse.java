package com.kyaw.blog.domain.dto;

import lombok.Builder;

@Builder
public record AuthResponse(
        String token,
        Long expiresIn
) {
}
