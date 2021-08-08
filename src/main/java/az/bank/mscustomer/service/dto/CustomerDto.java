package az.bank.mscustomer.service.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Set<ContactDto> contactDtoSet;
    private AddressDto addressDto;
}
