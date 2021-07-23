package az.bank.mscustomer.service.dto;

import az.bank.mscustomer.repository.entity.ContactType;
import lombok.Data;

@Data
public class ContactUpdateDto {
    private ContactType contactType;
    private String contactValue;
    private Long customerId;
}
