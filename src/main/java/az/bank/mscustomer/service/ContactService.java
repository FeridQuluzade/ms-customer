package az.bank.mscustomer.service;

import az.bank.mscustomer.service.dto.ContactCreateDto;
import az.bank.mscustomer.service.dto.ContactDto;

public interface ContactService {
    ContactDto createCustomer(ContactCreateDto createDto);

    ContactDto getContact(Long id);

    void deleteContact(Long id);
}
