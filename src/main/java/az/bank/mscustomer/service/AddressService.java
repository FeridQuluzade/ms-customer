package az.bank.mscustomer.service;

import az.bank.mscustomer.service.dto.AddressCreateDto;
import az.bank.mscustomer.service.dto.AddressDto;
import az.bank.mscustomer.service.dto.AddressUpdateDto;

public interface AddressService {

    AddressDto createAddress(AddressCreateDto addressCreateDto);

    AddressDto getAddress(Long id);

    AddressDto editAddress(Long id, AddressUpdateDto addressUpdateDto);

    void deleteAddress(Long id);
}
