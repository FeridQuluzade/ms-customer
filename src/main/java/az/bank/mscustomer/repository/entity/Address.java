package az.bank.mscustomer.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "customer_addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String city;
    private String street;

    @OneToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CustomerEntity customerEntity;

}
