package com.cg.newsapp.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.newsapp.exception.BadRequestException;
import com.cg.newsapp.exception.CategoryNotFoundException;
import com.cg.newsapp.exception.CountryNotFoundException;
import com.cg.newsapp.model.ErrorResponse;

@RestControllerAdvice
public class NewsErrorController {
	
	
	 @ExceptionHandler(value = BadRequestException.class) public
	  ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e)
	  { 
		  return new ResponseEntity<ErrorResponse>(new ErrorResponse(404, e.getMessage()), HttpStatus.BAD_REQUEST);
	  }
	  @ExceptionHandler(value = Exception.class) public
	  ResponseEntity<ErrorResponse> handleException(Exception e) { 
		  return new ResponseEntity<ErrorResponse>(new ErrorResponse(400, e.getMessage()),
	  HttpStatus.INTERNAL_SERVER_ERROR);
	 
	  }
	  
	  @ExceptionHandler(value = {CountryNotFoundException.class})
		@ResponseStatus(code = HttpStatus.NOT_FOUND)
		public ResponseEntity<ErrorResponse> handleCountryNotFoundException(Exception ex, HttpServletRequest request) {
			ErrorResponse body= new ErrorResponse(LocalDateTime.now(),
										HttpStatus.NOT_FOUND.value() , 
										ex.getClass().getSimpleName(), 
										ex.getLocalizedMessage(), 
										request.getRequestURI());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
		}
	  @ExceptionHandler(value = {CategoryNotFoundException.class})
		@ResponseStatus(code = HttpStatus.NOT_FOUND)
		public ResponseEntity<ErrorResponse> handleCategoryNotFoundException(Exception ex, HttpServletRequest request) {
			ErrorResponse body= new ErrorResponse(LocalDateTime.now(),
										HttpStatus.NOT_FOUND.value() , 
										ex.getClass().getSimpleName(), 
										ex.getLocalizedMessage(), 
										request.getRequestURI());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
		}

}
