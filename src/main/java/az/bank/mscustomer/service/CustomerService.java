package az.bank.mscustomer.service;


import az.bank.mscustomer.service.dto.CustomerCreateDto;
import az.bank.mscustomer.service.dto.CustomerDto;
import az.bank.mscustomer.service.dto.CustomerUpdateDto;

public interface CustomerService {

    CustomerDto createCustomer(CustomerCreateDto customerCreateDto);

    CustomerDto editCustomer(CustomerUpdateDto customerUpdateDto,Long id);

    CustomerDto getCustomer(Long id);

    void deleteCustomer(Long id);

}
