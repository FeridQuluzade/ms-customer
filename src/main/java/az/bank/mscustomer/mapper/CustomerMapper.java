package az.bank.mscustomer.mapper;

import az.bank.mscustomer.repository.entity.CustomerEntity;
import az.bank.mscustomer.service.dto.CustomerCreateDto;
import az.bank.mscustomer.service.dto.CustomerDto;
import az.bank.mscustomer.service.dto.CustomerUpdateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(CustomerEntity customerEntity);

    CustomerEntity fromDto(CustomerCreateDto customerCreateDto);

    CustomerEntity fromDto(CustomerUpdateDto customerUpdateDto);

}
