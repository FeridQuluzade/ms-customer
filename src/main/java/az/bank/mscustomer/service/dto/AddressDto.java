package az.bank.mscustomer.service.dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String country;
    private String city;
    private String street;
    private CustomerDto customerDto;
}
