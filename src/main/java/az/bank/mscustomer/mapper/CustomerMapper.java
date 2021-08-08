package az.bank.mscustomer.mapper;

import az.bank.mscustomer.repository.entity.CustomerEntity;
import az.bank.mscustomer.service.dto.CustomerCreateDto;
import az.bank.mscustomer.service.dto.CustomerDto;
import az.bank.mscustomer.service.dto.CustomerUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mappings({
            @Mapping(source = "customerEntity.customerContactAddress ", target = "contactDtoSet "),
            @Mapping(source = "customerEntity.addressEntity", target = "addressDto")})
    CustomerDto toDto(CustomerEntity customerEntity);

    @Mappings({
    @Mapping(source = "customerCreateDto.contactDtoSet ", target = "customerContactAddress"),
    @Mapping(source = "customerCreateDto.addressDto" ,target = "addressEntity")
    })
    CustomerEntity fromDto(CustomerCreateDto customerCreateDto);

    CustomerEntity fromDto(CustomerUpdateDto customerUpdateDto);

}
