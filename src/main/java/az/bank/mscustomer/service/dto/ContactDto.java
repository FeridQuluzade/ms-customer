package az.bank.mscustomer.service.dto;

import az.bank.mscustomer.repository.entity.ContactType;
import lombok.Data;

@Data
public class ContactDto {
    private Long id;
    private CustomerDto customerDto;
    private ContactType contactType;
    private String contactValue;
}
