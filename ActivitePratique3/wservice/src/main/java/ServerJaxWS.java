import jakarta.xml.ws.Endpoint;
import ws.BanqueService;

public class ServerJaxWS {
    public static void main(String[] args) {
        //demarer un serveur HTTP use port 9191 pour consulter le web service banqueService
        Endpoint.publish("http://0.0.0.0:9191/",new BanqueService());
        System.out.println("web service deploye sur http://0.0.0.0:9191");
    }
}
