package az.bank.mscustomer.repository.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ContactEntity> customerContactAddress;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity addressEntity;
//    private CustomerAddressEntity customerAddress;
}
