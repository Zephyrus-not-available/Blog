package com.kyaw.blog.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateRequestCategory(
        @NotBlank(message = "Category name must not be blank")
        @Size(min =2 ,max = 100, message = "Category name must not between {min} and {max} characters")
        @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Category name must not contain special characters")
        String name
) {
}
