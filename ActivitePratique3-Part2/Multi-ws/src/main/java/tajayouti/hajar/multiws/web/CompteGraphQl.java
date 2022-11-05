package tajayouti.hajar.multiws.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import tajayouti.hajar.multiws.entities.Compte;
import tajayouti.hajar.multiws.repositories.CompteRepository;

import java.util.List;

@Controller
public class CompteGraphQl {
    @Autowired
    private CompteRepository compteRepository;
    @QueryMapping
    public List<Compte> compteList()
    {
        return compteRepository.findAll();
    }
    @QueryMapping
    public Compte getCompte(@Argument Long id)
    {
        return compteRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Wallet %s not found",id)));
    }

    @MutationMapping
    public Compte addCompte(@Argument Compte compte)
    {
        return compteRepository.save(compte);
    }
}
