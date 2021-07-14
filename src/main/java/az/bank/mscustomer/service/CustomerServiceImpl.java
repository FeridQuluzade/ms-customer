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
    public CustomerDto editCustomer(CustomerUpdateDto updateDto,Long id) {
        getCustomerById(id)
                .ifPresent(customerDto1 -> {

                    Optional<CustomerEntity> entity = customerRepository
                            .findById(id);

                    customerRepository.save(CustomerMapper
                            .toEntityforUpdate(updateDto, entity)
                            .get());
                });


        return getCustomer(id);
    }

    @Override
    public CustomerDto getCustomer(Long id) {
        return getCustomerById(id).get();
    }

    @Override
    public void deleteCustomer(Long id) {
        getCustomerById(id)
                .ifPresent(x ->
                    customerRepository.deleteById(x.getId())
                );
    }
}
