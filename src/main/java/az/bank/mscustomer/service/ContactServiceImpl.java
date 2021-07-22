package az.bank.mscustomer.service;

import az.bank.mscustomer.exception.AddressNotFoundException;
import az.bank.mscustomer.mapper.ContactMapper;
import az.bank.mscustomer.repository.ContactRepository;
import az.bank.mscustomer.repository.entity.Contact;
import az.bank.mscustomer.repository.entity.CustomerEntity;
import az.bank.mscustomer.service.dto.ContactCreateDto;
import az.bank.mscustomer.service.dto.ContactDto;
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
        CustomerEntity customerEntity= customerService.findById(createDto.getCustomerId());

        Contact c=contactMapper.fromDto(createDto);
        c.setCustomer(customerEntity);
        contactRepository.save(c);

        return contactMapper.toDto(c);
    }

    @Override
    public ContactDto getContact(Long id) {
         return contactMapper.toDto(contactRepository
                 .findById(id).orElseThrow(()-> new AddressNotFoundException("Contact with given id not found:"+id)));
    }

    @Override
    public void deleteContact(Long id) {

        if (contactRepository.existsById(id)){
            contactRepository.deleteById(id);
        }else throw  new AddressNotFoundException("Contact with given id not found:"+id);
    }
}
