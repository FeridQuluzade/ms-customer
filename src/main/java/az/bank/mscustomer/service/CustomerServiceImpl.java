package az.bank.mscustomer.service;

import az.bank.mscustomer.exception.CustomerNotFoundException;
import az.bank.mscustomer.repository.CustomerRepository;
import az.bank.mscustomer.mapper.CustomerMapper;

import az.bank.mscustomer.repository.entity.CustomerEntity;
import az.bank.mscustomer.service.dto.CustomerDto;
import az.bank.mscustomer.service.dto.CustomerUpdateDto;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

//    private CustomerDto getCustomerById(Long id) {
//        return CustomerMapper
//                .toDto(customerRepository.findById(id)
//                        .orElseThrow(
//                                () -> new CustomerNotFoundException("Customer with given id not found: " + id)));
//    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        CustomerEntity entity = customerRepository
                .save(CustomerMapper
                        .toEntity(customerDto));
        customerDto.setId(entity.getId());
        return customerDto;
    }

    @Override
    public CustomerDto editCustomer(CustomerUpdateDto updateDto, Long id) {
        Optional<CustomerEntity> entity = customerRepository.findById(id);

        if (customerRepository.existsById(id)) {
            customerRepository.save(CustomerMapper
                    .toEntityforUpdate(updateDto, entity)
                    .get());
        }else throw new CustomerNotFoundException("Customer with given id not found: " + id);

        return getCustomer(id);
    }

    @Override
    public CustomerDto getCustomer(Long id) {
        return CustomerMapper.toDto(customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer with given id not found: " + id)));
    }

    @Override
    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else throw new CustomerNotFoundException("Customer with given id not found: " + id);
    }
}
