package az.bank.mscustomer.service;
import az.bank.mscustomer.service.dto.CustomerDto;


public interface CustomerService {
     CustomerDto createCustomer(CustomerDto customerCreateDto);

    CustomerDto editCustomer(CustomerDto customerUpdateDto, Long id);

    CustomerDto getCustomer(Long id);

    void deleteCustomer(Long id);
}
