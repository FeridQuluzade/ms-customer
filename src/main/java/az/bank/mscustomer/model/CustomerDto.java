package az.bank.mscustomer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate  birthDate;
    private String email;
    private String phoneNumber;


}
