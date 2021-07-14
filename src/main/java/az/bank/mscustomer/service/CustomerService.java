package az.bank.mscustomer.service;

import az.bank.mscustomer.model.CustomerDto;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto editCustomer(CustomerDto customerDto);

    CustomerDto getCustomer(Long id);

    void deleteCustomer(Long id);

}
