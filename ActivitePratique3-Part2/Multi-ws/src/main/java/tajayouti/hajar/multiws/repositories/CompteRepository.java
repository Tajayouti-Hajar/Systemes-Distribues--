package tajayouti.hajar.multiws.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tajayouti.hajar.multiws.entities.Compte;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long> {
}
