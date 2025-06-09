package com.library.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BorrowedBookDTO {
    private Long id;
    private Long bookId;
    private String bookTitle;
    private Long memberId;
    private String memberName;
    private LocalDate borrowDate;
    private LocalDate returnDate;
} 