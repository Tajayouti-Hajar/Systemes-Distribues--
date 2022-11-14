package tajayouti.sid.orderservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import tajayouti.sid.orderservice.entities.Order;

import java.util.List;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {
    @RestResource(path = "/byCustomerId") //accessible via data rest
    List<Order> findByCustomerId(@Param("customerId") long customerId);


}
