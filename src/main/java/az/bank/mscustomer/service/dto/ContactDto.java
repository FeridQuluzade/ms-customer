package az.bank.mscustomer.service.dto;

import az.bank.mscustomer.repository.entity.ContactType;
import az.bank.mscustomer.validation.AddData;
import az.bank.mscustomer.validation.ContactsConstraint;
import az.bank.mscustomer.validation.EditData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDto {

    private Long id;

    private ContactType contactType;
    private String contactValue;
}
