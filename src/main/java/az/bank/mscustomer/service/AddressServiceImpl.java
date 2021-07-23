package az.bank.mscustomer.service;

import az.bank.mscustomer.exception.AddressNotFoundException;
import az.bank.mscustomer.mapper.AddressMapper;
import az.bank.mscustomer.repository.AddressRepository;
import az.bank.mscustomer.repository.entity.AddressEntity;
import az.bank.mscustomer.repository.entity.CustomerEntity;
import az.bank.mscustomer.service.dto.AddressCreateDto;
import az.bank.mscustomer.service.dto.AddressDto;
import az.bank.mscustomer.service.dto.AddressUpdateDto;
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

        AddressEntity addressEntity = addressMapper.fromDto(addressCreateDto);
        addressEntity.setCustomerEntity(customerEntity);
        addressRepository.save(addressEntity);

        return addressMapper.toDto(addressEntity);
    }

    @Override
    public AddressDto getAddress(Long id) {
        return addressMapper.toDto(addressRepository.findById(id)
                .orElseThrow(
                        () -> new AddressNotFoundException("AddressEntity with given id not found: " + id)));
    }

    @Override
    public AddressDto editAddress(Long id, AddressUpdateDto addressUpdateDto) {
        CustomerEntity customerEntity=
                customerService
                        .findById(addressUpdateDto.getCustomerId());

        AddressEntity addressEntity =addressMapper.fromDto(addressUpdateDto);
        addressEntity.setId(id);
        addressEntity.setCustomerEntity(customerEntity);
        addressRepository.save(addressEntity);

        return addressMapper.toDto(addressEntity);
    }


    @Override
    public void deleteAddress(Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
        } else throw new AddressNotFoundException("AddressEntity with given id not found: " + id);
    }

}
