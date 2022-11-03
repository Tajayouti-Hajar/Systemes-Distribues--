package ord.openlab.openlabcustomerservice.services;

import lombok.AllArgsConstructor;
import ord.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import ord.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import ord.openlab.openlabcustomerservice.entities.Customer;
import ord.openlab.openlabcustomerservice.mappers.CustomerMapper;
import ord.openlab.openlabcustomerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;


    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer=customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer saveCustomer=customerRepository.save(customer);
        CustomerResponseDTO customerResponseDTO=customerMapper.customerToCustomerResponseDTO(saveCustomer);
        return customerResponseDTO ;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer= customerRepository.findById(id).get();
        return customerMapper.customerToCustomerResponseDTO(customer);
    }


    /***** a revoir*******/
    @Override
    public void deletCustomer(String id) {
        customerRepository.deleteById(id);
    }



    @Override
    public List<CustomerResponseDTO> listCustomers() {
        List<Customer> customers=customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS= customers.stream()
                .map(cust->customerMapper.customerToCustomerResponseDTO(cust))
                .collect(Collectors.toList());

        return customerResponseDTOS;
    }


    /***** a revoir*******/
    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer=customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer UpdatedCustomer=customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(UpdatedCustomer);
    }
}
