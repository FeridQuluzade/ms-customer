package az.bank.mscustomer.service.dto;

import az.bank.mscustomer.repository.entity.ContactType;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Set<CustomerContactDto> contactDtoSet;
    private AddressDto addressDto;
}
