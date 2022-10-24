package tajayouti.hajar.billingservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tajayouti.hajar.billingservice.entities.Customer;

import java.util.List;

@FeignClient (name = "CUSTOMER-SERVICE") //nom de micro service
public interface CustomerRestClient {
    @GetMapping(path = "/api/customers/{id}")
    Customer getCustomer(@PathVariable(name = "id") String id);
    @GetMapping(path="/api/customers/")
    List <Customer> allCustomerS();

}
