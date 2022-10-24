package tajayouti.hajar.billingservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import tajayouti.hajar.billingservice.dto.InvoiceRequestDTO;
import tajayouti.hajar.billingservice.entities.Invoice;
import tajayouti.hajar.billingservice.services.InvoiceService;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients //activer  FeignClient
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(InvoiceService invoiceService)
	{
		return args -> {
			invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(12000),"C001"));
			invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(8000),"C001"));
			invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(9000),"C002"));

		};
	}


}
