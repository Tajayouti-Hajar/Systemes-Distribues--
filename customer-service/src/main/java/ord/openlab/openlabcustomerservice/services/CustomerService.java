package ord.openlab.openlabcustomerservice.services;

import ord.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import ord.openlab.openlabcustomerservice.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    void deletCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO > listCustomers();


}
