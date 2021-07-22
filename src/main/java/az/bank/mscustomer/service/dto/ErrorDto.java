package az.bank.mscustomer.service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    private String message;
    private String code;
}
