package az.bank.mscustomer.service;

import az.bank.mscustomer.exception.CustomerNotFoundException;
import az.bank.mscustomer.mapper.CustomerMapper;
import az.bank.mscustomer.repository.CustomerRepository;
import az.bank.mscustomer.repository.entity.AddressEntity;
import az.bank.mscustomer.repository.entity.CustomerEntity;
import az.bank.mscustomer.service.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    protected CustomerEntity findById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer with given id not found: " + id));
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerCreateDto) {
        return customerMapper.toDto(
                customerRepository.save(
                        customerMapper.fromDto(customerCreateDto)));
    }

    @Override
    public CustomerDto editCustomer(CustomerDto updateDto, Long id) {
        CustomerEntity customerDb = findById(id);
        AddressEntity addressEntity = customerDb.getAddress();

        CustomerEntity customerUpdateEntity = customerMapper.fromDto(updateDto);
        AddressEntity addressUpdateEntity = customerUpdateEntity.getAddress();

        addressUpdateEntity.setId(addressEntity.getId());
        customerUpdateEntity.setId(id);
        customerUpdateEntity.setAddress(addressUpdateEntity);

        return customerMapper.toDto(customerRepository.save(customerUpdateEntity));
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