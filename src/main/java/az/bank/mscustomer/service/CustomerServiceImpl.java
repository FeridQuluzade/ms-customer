package az.bank.mscustomer.service;

import az.bank.mscustomer.exception.CustomerNotFoundException;
import az.bank.mscustomer.mapper.CustomerMapper;
import az.bank.mscustomer.repository.ContactRepository;
import az.bank.mscustomer.repository.CustomerRepository;
import az.bank.mscustomer.repository.entity.ContactEntity;
import az.bank.mscustomer.repository.entity.CustomerEntity;
import az.bank.mscustomer.service.dto.CustomerContactDto;
import az.bank.mscustomer.service.dto.CustomerCreateDto;
import az.bank.mscustomer.service.dto.CustomerDto;
import az.bank.mscustomer.service.dto.CustomerUpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ContactRepository contactRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               ContactRepository contactRepository,
                               CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.contactRepository = contactRepository;
        this.customerMapper = customerMapper;
    }

    protected CustomerEntity findById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer with given id not found: " + id));
    }

    @Override
    public CustomerDto createCustomer(CustomerCreateDto customerCreateDto) {
        CustomerEntity entity = customerRepository
                .save(customerMapper.fromDto(customerCreateDto));
        return   customerMapper.toDto(entity);
    }

    @Override
    public CustomerDto editCustomer(CustomerUpdateDto updateDto, Long id) {
        findById(id);

        CustomerEntity customerEntity = customerMapper.fromDto(updateDto);
        customerEntity.setId(id);
        customerRepository.save(customerEntity);

        return customerMapper.toDto(customerEntity);
    }

    @Override
    public CustomerDto getCustomer(Long id) {
        CustomerDto customerDto = customerMapper.toDto(findById(id));

         CustomerEntity entity=findById(id);
        Set<ContactEntity> contactEntities=entity.getCustomerContactAddress();

        for (ContactEntity c:
             contactEntities) {
            log.info(c.getId().toString());
        }
        for (CustomerContactDto c:
             customerDto.getContactDtoSet()) {
            log.info(c.toString());
        }
        return customerDto;
    }

    @Override
    public void deleteCustomer(Long id) {
        findById(id);
        customerRepository.deleteById(id);
    }
}