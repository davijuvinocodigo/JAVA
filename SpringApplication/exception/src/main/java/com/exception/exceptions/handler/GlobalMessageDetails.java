package com.exception.exceptions.handler;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GlobalMessageDetails {
    private String title;
    private int status;
    private String details;
    private String message;
    private LocalDateTime timestamp;
}
