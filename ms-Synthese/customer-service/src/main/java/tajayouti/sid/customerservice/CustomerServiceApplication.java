package tajayouti.sid.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import tajayouti.sid.customerservice.entities.Customer;
import tajayouti.sid.customerservice.repo.CustomerRepository;

import java.util.List;

@SpringBootApplication

public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository)
    {
        return args -> {
            customerRepository.saveAll(List.of(
                    Customer.builder().name("hajar").email("hajar@gmail.com").build(),
                    Customer.builder().name("sara").email("sara@gmail.com").build(),
                    Customer.builder().name("rim").email("rimr@gmail.com").build(),
                    Customer.builder().name("sofia").email("sofia@gmail.com").build()

            ));
        };


    }

}
