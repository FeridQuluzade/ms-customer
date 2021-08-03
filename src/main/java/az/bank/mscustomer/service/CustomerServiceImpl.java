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
        findById(id);

        CustomerEntity customerEntity= customerMapper.fromDto(updateDto);
        customerEntity.setId(id);
        customerRepository.save(customerEntity);

        return customerMapper.toDto(customerEntity);
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
        findById(id);
        customerRepository.deleteById(id);
    }
}