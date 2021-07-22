package az.bank.mscustomer.service;

import az.bank.mscustomer.exception.AddressNotFoundException;
import az.bank.mscustomer.mapper.AddressMapper;
import az.bank.mscustomer.repository.AddressRepository;
import az.bank.mscustomer.repository.entity.Address;
import az.bank.mscustomer.repository.entity.CustomerEntity;
import az.bank.mscustomer.service.dto.AddressCreateDto;
import az.bank.mscustomer.service.dto.AddressDto;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final CustomerServiceImpl customerService;

    public AddressServiceImpl(
            AddressMapper addressMapper,
            AddressRepository addressRepository,
            CustomerServiceImpl customerServiceImpl) {
        this.customerService = customerServiceImpl;
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressDto createAddress(AddressCreateDto addressCreateDto) {
        CustomerEntity customerEntity = customerService
                .findById(addressCreateDto.getCustomerId());

        Address address = addressMapper.fromDto(addressCreateDto);
        address.setCustomerEntity(customerEntity);
        addressRepository.save(address);

        return addressMapper.toDto(address);
    }

    @Override
    public AddressDto getAddress(Long id) {
        return addressMapper.toDto(addressRepository.findById(id)
                .orElseThrow(
                        () -> new AddressNotFoundException("Address with given id not found: " + id)));
    }

    @Override
    public void deleteAddress(Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
        } else throw new AddressNotFoundException("Address with given id not found: " + id);
    }

}
