package az.bank.mscustomer.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;

    private String country;
    private String city;
    private String street;
}
