package az.bank.mscustomer.service.dto;

import lombok.Data;

@Data
public class AddressCreateDto {
    private String country;
    private String city;
    private String street;
    private Long customerId;
}
