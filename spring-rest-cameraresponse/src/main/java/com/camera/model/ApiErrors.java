package com.camera.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiErrors {
    LocalDateTime dateAndTime;
    HttpStatus status;
    int statusCode;
    String error;
    List<String> message;
}
