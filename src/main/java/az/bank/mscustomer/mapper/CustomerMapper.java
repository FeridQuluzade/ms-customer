package az.bank.mscustomer.mapper;

import az.bank.mscustomer.dao.CustomerEntity;
import az.bank.mscustomer.model.CustomerDto;

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

    public static Optional<CustomerEntity> toEntityforUpdate(CustomerDto customerDto,
                                                             Optional<CustomerEntity> entity) {
        entity.get().setFirstName(customerDto.getFirstName());
        entity.get().setLastName(customerDto.getLastName());
        entity.get().setEmail(customerDto.getEmail());
        entity.get().setBirthDate(customerDto.getBirthDate());
        entity.get().setPhoneNumber(customerDto.getPhoneNumber());
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
