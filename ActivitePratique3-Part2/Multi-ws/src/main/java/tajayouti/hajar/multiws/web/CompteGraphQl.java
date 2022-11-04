package tajayouti.hajar.multiws.web;

import org.springframework.beans.factory.annotation.Autowired;
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

}
