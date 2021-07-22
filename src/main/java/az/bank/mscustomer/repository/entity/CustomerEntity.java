package az.bank.mscustomer.repository.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;




//    private CustomerAddressEntity customerAddress;

}
