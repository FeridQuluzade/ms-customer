package az.bank.mscustomer.service.dto;

import az.bank.mscustomer.repository.entity.ContactType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDto {
    private Long id;
    private ContactType contactType;
    private String contactValue;
}
