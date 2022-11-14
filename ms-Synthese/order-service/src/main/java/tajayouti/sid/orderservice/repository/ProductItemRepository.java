package tajayouti.sid.orderservice.repository;

;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import tajayouti.sid.orderservice.entities.ProductItem;

import java.util.List;

@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    @RestResource(path = "/byOrderId") //accessible via data rest
    List<ProductItem> findByOrderId(@Param("OrderId") long id);


}
