package com.ingecno.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	// handle specific exceptions
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(APIException.class)
	public ResponseEntity<?> handleAPIException(APIException exception, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}

	// handle global exception
	@SuppressWarnings("unchecked")
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

		return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// handling custom validation errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customeValidationErrorHandling(MethodArgumentNotValidException exception){
		ErrorDetails details=new ErrorDetails(new Date(), "validation Error", 
				exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity(details, HttpStatus.BAD_REQUEST);
		
		
		
	}

}
