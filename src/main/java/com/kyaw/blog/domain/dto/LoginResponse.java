package com.kyaw.blog.domain.dto;

import lombok.Builder;

@Builder
public record LoginResponse(
        String email,
        String password
) {
}
