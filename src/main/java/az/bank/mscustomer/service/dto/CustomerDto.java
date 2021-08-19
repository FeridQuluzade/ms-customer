package az.bank.mscustomer.service.dto;

import az.bank.mscustomer.validation.AddData;
import az.bank.mscustomer.validation.EditData;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Set;

@Data
public class CustomerDto {


    private Long id;


    private String firstName;

    @NotBlank
    private String lastName;

    @Past
    private LocalDate birthDate;

    @Valid
    private Set<ContactDto> customerContactAddress;

    @Valid
    private AddressDto address;
}
