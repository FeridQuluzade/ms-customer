package az.bank.mscustomer.mapper;

import az.bank.mscustomer.repository.entity.Address;
import az.bank.mscustomer.service.CustomerServiceImpl;
import az.bank.mscustomer.service.dto.AddressCreateDto;
import az.bank.mscustomer.service.dto.AddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class},imports = {CustomerServiceImpl.class})
public interface AddressMapper {

    @Mapping(source = "address.customerEntity", target = "customerDto")
    AddressDto toDto(Address address);

  //  @Mapping(source = "createDto.customerId",expression = "CustomerServiceImpl.getCustomer(createDto.customerId)", target = "customerEntity")
    Address fromDto(AddressCreateDto createDto);

}
