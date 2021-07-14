package az.bank.mscustomer.service;

import az.bank.mscustomer.dao.CustomerEntity;
import az.bank.mscustomer.dao.CustomerRepository;
import az.bank.mscustomer.mapper.CustomerMapper;
import az.bank.mscustomer.model.CustomerDto;
import az.bank.mscustomer.model.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private Optional<CustomerDto> getCustomerById(Long id) {
        return Optional.of(CustomerMapper
                .toDto(customerRepository.findById(id)
                        .orElseThrow(
                                () -> new CustomerNotFoundException("Customer with given id not found: " + id))));
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        CustomerEntity entity = customerRepository
                .save(CustomerMapper
                        .toEntity(customerDto));
        customerDto.setId(entity.getId());
        return customerDto;
    }

    @Override
    public CustomerDto editCustomer(CustomerDto customerDto) {
        getCustomerById(customerDto.getId())
                .ifPresent(customerDto1 -> {

                    Optional<CustomerEntity> entity = customerRepository
                            .findById(customerDto.getId());

                    customerRepository.save(CustomerMapper
                            .toEntityforUpdate(customerDto, entity)
                            .get());
                });
        return customerDto;
    }

    @Override
    public CustomerDto getCustomer(Long id) {
        return getCustomerById(id).get();
    }

    @Override
    public void deleteCustomer(Long id) {
        getCustomerById(id)
                .ifPresent(x -> {
                    customerRepository.deleteById(x.getId());
                });
    }
}
