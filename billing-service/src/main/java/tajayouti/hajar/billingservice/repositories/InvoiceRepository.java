package tajayouti.hajar.billingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tajayouti.hajar.billingservice.entities.Customer;
import tajayouti.hajar.billingservice.entities.Invoice;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,String> {
    List<Invoice> findByCustomerID(String idCustomer);


}
