package az.bank.mscustomer.mapper;

import az.bank.mscustomer.repository.entity.CustomerEntity;
import az.bank.mscustomer.service.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(CustomerEntity customerEntity);

    CustomerEntity fromDto(CustomerDto customerDto);

//    @Mappings({
//            @Mapping(source = "customerCreateDto.contactDtoSet ", target = "customerContactAddress"),
//            @Mapping(source = "customerCreateDto.addressDto", target = "addressEntity")
//    })
//    CustomerEntity fromDto(CustomerCreateDto customerCreateDto);
//
//    CustomerEntity fromDto(CustomerUpdateDto customerUpdateDto);

}
