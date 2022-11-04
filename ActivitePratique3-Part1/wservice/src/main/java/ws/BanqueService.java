package ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;

@WebService(serviceName = "BanqueWS")
public class BanqueService {

    @WebMethod(operationName = "Convert")
    public double Conversion(@WebParam (name = "montant") double montant)
    {
        return montant/10;
    }

    @WebMethod
    public Compte getCompte(@WebParam(name = "code") int id)
    {

        return new Compte(id,Math.random()*988,new Date());
    }


     @WebMethod
    public List<Compte> listComptes()
    {
        return List.of(
               new  Compte(1,Math.random()*988,new Date()),
        new  Compte(2,Math.random()*988,new Date()),
        new  Compte(3,Math.random()*988,new Date())
        );
    }
}
