package az.bank.mscustomer.repository;

import az.bank.mscustomer.repository.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
