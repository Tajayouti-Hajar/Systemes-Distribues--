package ord.openlab.openlabcustomerservice;

import ord.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import ord.openlab.openlabcustomerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenlabCustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenlabCustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService)
    {
        return args -> {
            customerService.save(new CustomerRequestDTO("C001","hajar","Tajayouti@gmail.com"));
            customerService.save(new CustomerRequestDTO("C002","sara","sara@gmail.com"));
        };
    }
}
