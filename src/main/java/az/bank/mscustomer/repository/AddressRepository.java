package az.bank.mscustomer.repository;

import az.bank.mscustomer.repository.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity,Long> {

}
