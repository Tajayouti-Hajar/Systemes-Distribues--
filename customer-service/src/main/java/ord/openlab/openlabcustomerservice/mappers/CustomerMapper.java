package ord.openlab.openlabcustomerservice.mappers;

import ord.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import ord.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import ord.openlab.openlabcustomerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
   CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
}
