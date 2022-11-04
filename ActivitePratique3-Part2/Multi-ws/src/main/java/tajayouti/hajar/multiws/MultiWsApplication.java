package tajayouti.hajar.multiws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import tajayouti.hajar.multiws.entities.Compte;
import tajayouti.hajar.multiws.repositories.CompteRepository;

import java.util.Date;

@SpringBootApplication
public class MultiWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiWsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CompteRepository compteRepository, RepositoryRestConfiguration restConfiguration)
	{
		return args -> {
			restConfiguration.exposeIdsFor(Compte.class);
			compteRepository.save(new Compte(null,Math.random()*9090,new Date()));
			compteRepository.save(new Compte(null,Math.random()*9090,new Date()));
			compteRepository.save(new Compte(null,Math.random()*9090,new Date()));

		};
	}

}
