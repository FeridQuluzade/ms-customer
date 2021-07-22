package az.bank.mscustomer.mapper;

import az.bank.mscustomer.repository.entity.Address;
import az.bank.mscustomer.repository.entity.Contact;
import az.bank.mscustomer.repository.entity.ContactType;
import az.bank.mscustomer.service.dto.ContactCreateDto;
import az.bank.mscustomer.service.dto.ContactDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface ContactMapper {
    @Mapping(source = "contact.customer", target = "customerDto")
    ContactDto toDto(Contact contact);


    Contact fromDto(ContactCreateDto createDto);

}
