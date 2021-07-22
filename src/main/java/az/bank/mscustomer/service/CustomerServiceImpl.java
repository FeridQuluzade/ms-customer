package az.bank.mscustomer.service;

import az.bank.mscustomer.exception.CustomerNotFoundException;
import az.bank.mscustomer.mapper.CustomerMapper;
import az.bank.mscustomer.repository.CustomerRepository;
import az.bank.mscustomer.repository.entity.CustomerEntity;
import az.bank.mscustomer.service.dto.CustomerCreateDto;
import az.bank.mscustomer.service.dto.CustomerDto;
import az.bank.mscustomer.service.dto.CustomerUpdateDto;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository
            , CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDto createCustomer(CustomerCreateDto customerCreateDto) {
        CustomerEntity entity = customerRepository
                .save(customerMapper.fromDto(customerCreateDto));

       return customerMapper.toDto(entity);
    }

    @Override
    public CustomerDto editCustomer(CustomerUpdateDto updateDto, Long id) {
        CustomerDto customerDto;
        if (customerRepository.existsById(id)) {
            customerDto = customerMapper.toDto(customerRepository.save(customerMapper
                    .fromDto(updateDto)));
        } else throw new CustomerNotFoundException("Customer with given id not found: " + id);

        return customerDto;
    }

    protected CustomerEntity findById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer with given id not found: " + id));
    }

    @Override
    public CustomerDto getCustomer(Long id) {
        return customerMapper.toDto(findById(id));
    }

    @Override
    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else throw new CustomerNotFoundException("Customer with given id not found: " + id);
    }
}

//    private CustomerDto getCustomerById(Long id) {
//        return CustomerMapper
//                .toDto(customerRepository.findById(id)
//                        .orElseThrow(
//                                () -> new CustomerNotFoundException("Customer with given id not found: " + id)));
//    }