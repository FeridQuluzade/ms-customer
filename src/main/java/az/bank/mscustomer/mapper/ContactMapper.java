package az.bank.mscustomer.mapper;

import az.bank.mscustomer.repository.entity.ContactEntity;
import az.bank.mscustomer.service.dto.ContactCreateDto;
import az.bank.mscustomer.service.dto.ContactDto;
import az.bank.mscustomer.service.dto.ContactUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface ContactMapper {

    @Mapping(source = "contactEntity.customer", target = "customerDto")
    ContactDto toDto(ContactEntity contactEntity);

    ContactEntity fromDto(ContactUpdateDto contactUpdateDto);

    ContactEntity fromDto(ContactCreateDto createDto);

}
