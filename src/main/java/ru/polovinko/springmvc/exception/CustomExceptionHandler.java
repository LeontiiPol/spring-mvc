package ru.polovinko.springmvc.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.polovinko.springmvc.dto.ErrorDto;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(InvalidNameHeaderException.class)
    public ResponseEntity<ErrorDto> handleInvalidHeader(InvalidNameHeaderException e) {
        return ResponseEntity.status(500)
                .body(
                        new ErrorDto()
                                .setCode(500)
                                .setDescription(e.getMessage())
                );
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BadRequestException.class})
    public ResponseEntity<ErrorDto> handleValidation(Exception e) {
        return ResponseEntity.status(400).body(
                new ErrorDto()
                        .setCode(400)
                        .setDescription(e.getMessage())
        );
    }
}
