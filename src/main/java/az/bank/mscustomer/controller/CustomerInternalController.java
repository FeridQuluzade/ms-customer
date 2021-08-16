package az.bank.mscustomer.controller;

import az.bank.mscustomer.service.CustomerService;
import az.bank.mscustomer.service.dto.CustomerCreateDto;
import az.bank.mscustomer.service.dto.CustomerDto;
import az.bank.mscustomer.service.dto.CustomerUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/internal/customers")
public class CustomerInternalController {
    private final CustomerService customerService;

    public CustomerInternalController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") Long id) {
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }
}
