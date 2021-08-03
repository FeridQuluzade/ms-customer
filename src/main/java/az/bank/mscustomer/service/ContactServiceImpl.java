package az.bank.mscustomer.service;

import az.bank.mscustomer.exception.ContactNotFoundException;
import az.bank.mscustomer.mapper.ContactMapper;

import az.bank.mscustomer.repository.ContactRepository;
import az.bank.mscustomer.repository.entity.ContactEntity;
import az.bank.mscustomer.repository.entity.CustomerEntity;
import az.bank.mscustomer.service.dto.ContactCreateDto;
import az.bank.mscustomer.service.dto.ContactDto;
import az.bank.mscustomer.service.dto.ContactUpdateDto;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;
    private final CustomerServiceImpl customerService;

    public ContactServiceImpl(ContactRepository contactRepository,
                              ContactMapper contactMapper,
                              CustomerServiceImpl customerServiceImpl) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
        this.customerService = customerServiceImpl;
    }

    @Override
    public ContactDto createCustomer(ContactCreateDto createDto) {
        CustomerEntity customerEntity = customerService.findById(createDto.getCustomerId());

        ContactEntity c = contactMapper.fromDto(createDto);
        c.setCustomer(customerEntity);
        contactRepository.save(c);

        return contactMapper.toDto(c);
    }

    private ContactEntity findContact(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact with given id not found:" + id));
    }

    @Override
    public ContactDto getContact(Long id) {
        return contactMapper.toDto(findContact(id));
    }

    @Override
    public ContactDto editContact(Long id, ContactUpdateDto contactUpdateDto) {
        CustomerEntity customerEntity = customerService
                .findById(contactUpdateDto.getCustomerId());
        findContact(id);

        ContactEntity contactEntity = contactMapper.fromDto(contactUpdateDto);
        contactEntity.setId(id);
        contactEntity.setCustomer(customerEntity);

        contactRepository.save(contactEntity);

        return contactMapper.toDto(contactEntity);
    }

    @Override
    public void deleteContact(Long id) {
        findContact(id);
        contactRepository.deleteById(id);
    }
}
