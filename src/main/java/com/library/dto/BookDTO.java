package com.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class BookDTO {
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Publishing year is required")
    @Min(value = 1000, message = "Publishing year must be a valid year")
    private Integer publishingYear;

    @NotNull(message = "Author ID is required")
    private Long authorId;

    private String authorName;
} 