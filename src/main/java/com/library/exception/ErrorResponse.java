package com.library.exception;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private List<String> details;
    private String path;

    public ErrorResponse(int status, String error, List<String> details, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.details = details;
        this.path = path;
    }
} 