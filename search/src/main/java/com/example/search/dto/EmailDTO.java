package com.example.search.dto;

import lombok.Data;

/**
 * @author freedom
 */
@Data
public class EmailDTO {
    private String recipient;
    private String subject;
    private String content;
}
