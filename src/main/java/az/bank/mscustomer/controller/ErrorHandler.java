package az.bank.mscustomer.controller;

import az.bank.mscustomer.model.ErrorDto;
import az.bank.mscustomer.model.exception.CustomerNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFoundException(WebRequest webRequest,
                                                                  CustomerNotFoundException customerNotFoundException) {
        return handleExceptionInternal(customerNotFoundException,
                new ErrorDto("customer.not-found", customerNotFoundException.getMessage()),
                new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleAllException(Exception e,
                                                     WebRequest webRequest) {
        return handleExceptionInternal(e,
                new ErrorDto("uxexpected.exception", e.getMessage()),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, webRequest
        );
    }
}
