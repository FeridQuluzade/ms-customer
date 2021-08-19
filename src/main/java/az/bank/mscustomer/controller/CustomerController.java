package az.bank.mscustomer.controller;

import az.bank.mscustomer.service.CustomerService;
import az.bank.mscustomer.service.dto.CustomerDto;
import az.bank.mscustomer.validation.AddData;
import az.bank.mscustomer.validation.EditData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") Long id) {
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CustomerDto> addCustomer(@Validated(AddData.class) @RequestBody CustomerDto customerCreateDto) {
        return new ResponseEntity<>(customerService.createCustomer(customerCreateDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> editCustomer(@PathVariable("id") Long id,
                                                    @RequestBody CustomerDto customerUpdateDto) {
        return new ResponseEntity<>(customerService.editCustomer(customerUpdateDto, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
