package tajayouti.hajar.multiws.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tajayouti.hajar.multiws.entities.Compte;
import tajayouti.hajar.multiws.repositories.CompteRepository;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Component
@WebService(serviceName = "BanqueWS")
public class CompteSoapService {
    @Autowired
    private CompteRepository compteRepository;

    //consulter la liste des comptes
    @WebMethod
    public List<Compte> compteList()
    {
        return compteRepository.findAll();
    }

    @WebMethod
    public Compte getCompte(@WebParam(name ="id") Long id)
    {
        return compteRepository.findById(id).get();
    }
}
