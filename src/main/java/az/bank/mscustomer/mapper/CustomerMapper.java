package az.bank.mscustomer.mapper;


import az.bank.mscustomer.repository.entity.CustomerEntity;
import az.bank.mscustomer.service.dto.CustomerDto;
import az.bank.mscustomer.service.dto.CustomerUpdateDto;

import java.util.Optional;

public class CustomerMapper {

    public static CustomerEntity toEntity(CustomerDto customerDto) {
        CustomerEntity entity = new CustomerEntity();
        entity.setFirstName(customerDto.getFirstName());
        entity.setLastName(customerDto.getLastName());
        entity.setBirthDate(customerDto.getBirthDate());
        entity.setEmail(customerDto.getEmail());
        entity.setPhoneNumber(customerDto.getPhoneNumber());
        return entity;
    }

    public static Optional<CustomerEntity> toEntityforUpdate(CustomerUpdateDto customerUpdateDto,
                                                             Optional<CustomerEntity> entity) {

        entity.get().setFirstName(customerUpdateDto.getFirstName());
        entity.get().setLastName(customerUpdateDto.getLastName());
        entity.get().setEmail(customerUpdateDto.getEmail());
        entity.get().setBirthDate(customerUpdateDto.getBirthDate());
        entity.get().setPhoneNumber(customerUpdateDto.getPhoneNumber());
        return entity;
    }

    public static CustomerDto toDto(CustomerEntity customerEntity) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customerEntity.getId());
        customerDto.setFirstName(customerEntity.getFirstName());
        customerDto.setLastName(customerEntity.getLastName());
        customerDto.setBirthDate(customerEntity.getBirthDate());
        customerDto.setEmail(customerEntity.getEmail());
        customerDto.setPhoneNumber(customerEntity.getPhoneNumber());
        return customerDto;

    }
}
