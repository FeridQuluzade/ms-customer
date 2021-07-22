package az.bank.mscustomer.service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerCreateDto {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
