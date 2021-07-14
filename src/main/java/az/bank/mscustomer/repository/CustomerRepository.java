package az.bank.mscustomer.repository;

import az.bank.mscustomer.repository.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository <CustomerEntity,Long>{

}
