package com.hdfc.capstone.employee.client.globalexceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hdfc.capstone.employee.client.exception.InvalidEmployeeIdException;

@RestControllerAdvice
public class GlobalExceptionhandler {


	@ExceptionHandler(InvalidEmployeeIdException.class)
	public ResponseEntity<String> handleExp(InvalidEmployeeIdException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
}

}
