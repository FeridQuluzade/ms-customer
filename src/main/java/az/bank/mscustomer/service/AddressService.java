package az.bank.mscustomer.service;

import az.bank.mscustomer.service.dto.AddressCreateDto;
import az.bank.mscustomer.service.dto.AddressDto;

public interface AddressService {

    AddressDto createAddress(AddressCreateDto addressCreateDto);

    AddressDto getAddress(Long id);

    void deleteAddress(Long id);
}
