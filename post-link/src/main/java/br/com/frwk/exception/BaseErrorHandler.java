package br.com.frwk.exception;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.frwk.dto.ResponseDTO;
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

	@ResponseBody
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleException(MethodArgumentNotValidException exception) {
		BindingResult result = exception.getBindingResult();
		List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
		String errorMsg = fieldErrors.stream()
				.map(error -> "@Campo -> " + error.getField().concat(" - Erro -> ")
						.concat(error.getDefaultMessage().concat(". ")))
				.collect(Collectors.joining());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTO.forError(errorMsg));
	}

}
