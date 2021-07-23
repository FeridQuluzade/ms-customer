package az.bank.mscustomer.mapper;

import az.bank.mscustomer.repository.entity.AddressEntity;
import az.bank.mscustomer.service.CustomerServiceImpl;
import az.bank.mscustomer.service.dto.AddressCreateDto;
import az.bank.mscustomer.service.dto.AddressDto;
import az.bank.mscustomer.service.dto.AddressUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class},imports = {CustomerServiceImpl.class})
public interface AddressMapper {

    @Mapping(source = "addressEntity.customerEntity", target = "customerDto")
    AddressDto toDto(AddressEntity addressEntity);

  //  @Mapping(source = "createDto.customerId",expression = "CustomerServiceImpl.getCustomer(createDto.customerId)", target = "customerEntity")
    AddressEntity fromDto(AddressCreateDto createDto);

    AddressEntity fromDto(AddressUpdateDto addressUpdateDto);

}
