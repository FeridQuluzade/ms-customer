package az.bank.mscustomer.service.dto;

import lombok.Data;

@Data
public class AddressUpdateDto {
    private String country;
    private String city;
    private String street;
}
