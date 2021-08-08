package az.bank.mscustomer.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerCreateDto {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Set<CustomerContactDto> contactDtoSet;
    private AddressCreateDto addressDto;
}
