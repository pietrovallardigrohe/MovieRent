package Database;

import Rent.*;
import java.util.List;

public interface IDatabase {


    public List<Kart> getKarts();
    public List<Client> getClients();
    public List<DVD> getDVDs();

    public boolean verifyLogin(String user, String password);

    public boolean registerKart(Kart kart);
    public boolean registerClient(Client client);
    public boolean registerDVD(DVD dvd);

    public int getKartId();

}
