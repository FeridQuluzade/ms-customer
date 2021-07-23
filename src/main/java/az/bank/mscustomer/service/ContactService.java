package az.bank.mscustomer.service;

import az.bank.mscustomer.service.dto.ContactCreateDto;
import az.bank.mscustomer.service.dto.ContactDto;
import az.bank.mscustomer.service.dto.ContactUpdateDto;

public interface ContactService {
    ContactDto createCustomer(ContactCreateDto createDto);

    ContactDto getContact(Long id);

    ContactDto editContact(Long id, ContactUpdateDto contactUpdateDto);

    void deleteContact(Long id);
}
