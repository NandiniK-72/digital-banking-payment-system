package com.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bank.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<ErrorResponse>
    handleNotFound(ResourceNotFoundException ex) {

        ErrorResponse response =new ErrorResponse(ex.getMessage(),404);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
	
	@ExceptionHandler(
            DuplicateResourceException.class)

    public ResponseEntity<ErrorResponse>
    handleDuplicate(

            DuplicateResourceException ex) {

        ErrorResponse response =
                new ErrorResponse(
                        ex.getMessage(),
                        409);

        return new ResponseEntity<>(
                response,
                HttpStatus.CONFLICT);
    }
	
	
	 @ExceptionHandler(
	            InsufficientBalanceException.class)

	    public ResponseEntity<ErrorResponse>
	    handleBalance(

	            InsufficientBalanceException ex) {

	        ErrorResponse response =
	                new ErrorResponse(
	                        ex.getMessage(),
	                        400);

	        return new ResponseEntity<>(
	                response,
	                HttpStatus.BAD_REQUEST);
	    }
	 
	 
	 @ExceptionHandler(Exception.class)

	    public ResponseEntity<ErrorResponse>
	    handleGeneric(Exception ex) {

	        ErrorResponse response =
	                new ErrorResponse(
	                        ex.getMessage(),
	                        500);

	        return new ResponseEntity<>(
	                response,
	                HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
	 
	 @ExceptionHandler(
			 MethodArgumentNotValidException.class)

			 public ResponseEntity<String>
			 handleValidation(
			 MethodArgumentNotValidException ex){

			     String error =
			             ex.getBindingResult()
			             .getFieldError()
			             .getDefaultMessage();

			     return ResponseEntity
			             .badRequest()
			             .body(error);
			 }

}
