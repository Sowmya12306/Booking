package com.trainbooking.microservice.exception;
import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author SOWMYA PEDDI
 *
 */
@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
 

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException ex) {
        LOGGER.info("Start : handleBadRequestException {}", ex);
        ExceptionResponse response = new ExceptionResponse();
        Errors errors = new Errors();

        response.setRequestIdentifier(ex.getRequestIdentifier());
        response.setSuccess(false);
        response.setTransactionDate(LocalDateTime.now().toString());

        errors.setErrorMessage(ex.getErrorMessage());
        errors.setExceptionResponse(ex.getErrors());
        response.setErrors(errors);
        LOGGER.info("End  : handleBadRequestException with response {}", response);
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
  
   	
}
