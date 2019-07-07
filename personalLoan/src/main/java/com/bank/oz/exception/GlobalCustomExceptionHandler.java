package com.bank.oz.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalCustomExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<CustomMessage> notFoundException(CustomException errMsg) {
		CustomMessage resposne = new CustomMessage(LocalDate.now(), errMsg.getMessage());
		return new ResponseEntity<>(resposne, HttpStatus.NOT_FOUND);
	}
}
