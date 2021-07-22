package az.bank.mscustomer.service.dto;

import lombok.*;

import java.time.LocalDate;

@Data
public class CustomerUpdateDto {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

}
