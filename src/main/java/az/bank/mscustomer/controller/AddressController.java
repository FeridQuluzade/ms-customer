package az.bank.mscustomer.controller;

import az.bank.mscustomer.service.AddressService;
import az.bank.mscustomer.service.dto.AddressCreateDto;
import az.bank.mscustomer.service.dto.AddressDto;
import az.bank.mscustomer.service.dto.AddressUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable("id") Long id){
        return  new ResponseEntity<>(addressService.getAddress(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressCreateDto addressCreateDto) {
        return new ResponseEntity<>(addressService.createAddress(addressCreateDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDto> editAddress(@PathVariable("id") Long id,
                                                  @RequestBody AddressUpdateDto addressUpdateDto){
        return  new ResponseEntity<>(addressService.editAddress(id,addressUpdateDto),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable("id") Long id){
        addressService.deleteAddress(id);
       return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
