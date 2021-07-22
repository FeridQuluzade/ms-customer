package az.bank.mscustomer.controller;

import az.bank.mscustomer.exception.AddressNotFoundException;
import az.bank.mscustomer.exception.ContactNotFoundException;
import az.bank.mscustomer.exception.CustomerNotFoundException;

import az.bank.mscustomer.service.dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFoundException(WebRequest webRequest,
                                                                  CustomerNotFoundException customerNotFoundException) {
        return handleExceptionInternal(customerNotFoundException,
                new ErrorDto("customer.not-found", customerNotFoundException.getMessage()),
                new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<Object> handleAddressNotFoundException(WebRequest webRequest,
                                                                 AddressNotFoundException addressNotFoundException) {
        return handleExceptionInternal(addressNotFoundException,
                new ErrorDto("address.not-found", addressNotFoundException.getMessage()),
                new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleAllException(Exception e,
                                                     WebRequest webRequest) {
        return handleExceptionInternal(e,
                new ErrorDto("unexpected.exception", e.getMessage()),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, webRequest
        );
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleContactNotFoundException(WebRequest webRequest,
                                                                 ContactNotFoundException contactNotFoundException){
        return handleExceptionInternal(contactNotFoundException,
                new ErrorDto("contact.not-found",contactNotFoundException.getMessage()),
                new HttpHeaders(),HttpStatus.NOT_FOUND,webRequest);
    }

}
