package br.com.frwk.blog.post.exception;


import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.frwk.blog.post.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class BaseErrorHandler {

    @ResponseBody
    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<?> handleException(ValidationException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTO.forError(exception.getMessage()));
    }
    
    @ResponseBody
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<?> handleException(EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseDTO.forError("Registro não localizado"));
    }
}
