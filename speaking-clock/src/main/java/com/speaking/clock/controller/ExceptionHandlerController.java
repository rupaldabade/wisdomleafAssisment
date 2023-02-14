package com.speaking.clock.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.speaking.clock.exception.InvalidTimeException;
import com.speaking.clock.exception.TimeConvertionException;
import com.speaking.clock.exception.TimeNotfoundException;
import com.speaking.clock.exception.NumberFormaterException;
import com.speaking.clock.model.ApiResponseModel;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(TimeNotfoundException.class)
	public ResponseEntity<Object> timeNotfoundException(
			Exception ex, WebRequest request) {
		ApiResponseModel response = new ApiResponseModel();
		response.setMsg("Time value not found");
		response.setDateTime(LocalDateTime.now());
		ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		return entity;
	}

	@ExceptionHandler(NumberFormaterException.class)
	public ResponseEntity<Object> numberFormatException(
			Exception ex, WebRequest request) {
		ApiResponseModel response = new ApiResponseModel();
		response.setMsg("You need to pass a valid 24 hour format hour like 12:55");
		response.setDateTime(LocalDateTime.now());
		ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
		return entity;
	}
	
	@ExceptionHandler(TimeConvertionException.class)
	public ResponseEntity<Object> timeConvertionException(
			Exception ex, WebRequest request) {
		ApiResponseModel response = new ApiResponseModel();
		response.setMsg("It was not possible to convert the hour passed to words");
		response.setDateTime(LocalDateTime.now());
		ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		return entity;
	}
	
	@ExceptionHandler(InvalidTimeException.class)
	public ResponseEntity<Object> invalidTimeException(
			Exception ex, WebRequest request) {
		ApiResponseModel response = new ApiResponseModel();
		response.setMsg("Given time is invalid");
		response.setDateTime(LocalDateTime.now());
		ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		return entity;
	}
}
