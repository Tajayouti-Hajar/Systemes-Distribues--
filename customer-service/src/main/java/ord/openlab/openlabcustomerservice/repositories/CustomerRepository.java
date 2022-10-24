package ord.openlab.openlabcustomerservice.repositories;

import ord.openlab.openlabcustomerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
