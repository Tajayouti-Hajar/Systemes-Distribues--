package ord.openlab.openlabcustomerservice.web;

import lombok.AllArgsConstructor;
import ord.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import ord.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import ord.openlab.openlabcustomerservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/api") //
@AllArgsConstructor
public class ControllerRestAPI {
    private CustomerService customerService;

    @GetMapping(path="/customers")
   public List<CustomerResponseDTO > allCustomerS()
    {
        return customerService.listCustomers();
    }

    @PostMapping(path = "/customers")
    public CustomerResponseDTO  save(@RequestBody CustomerRequestDTO customerRequestDTO)
    {
        customerRequestDTO.setId(UUID.randomUUID().toString());
    return customerService.save(customerRequestDTO);
    }
    @GetMapping(path = "/customers/{id}")
   public CustomerResponseDTO getCustomer(@PathVariable String id)
    {
        return customerService.getCustomer(id);
    }





}
