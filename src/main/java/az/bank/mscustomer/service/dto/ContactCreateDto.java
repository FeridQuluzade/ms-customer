package az.bank.mscustomer.service.dto;


import az.bank.mscustomer.repository.entity.ContactType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactCreateDto {
    private ContactType contactType;
    private String contactValue;
}
