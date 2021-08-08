package az.bank.mscustomer.service.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
public class CustomerUpdateDto {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Set<ContactUpdateDto> customerContactAddress;
    private AddressUpdateDto addressEntity;
}
