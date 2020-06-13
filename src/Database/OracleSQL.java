package Database;

import Rent.Client;
import Rent.DVD;
import Rent.Kart;

import java.util.List;

public class OracleSQL implements IDatabase {

    @Override
    public List<Kart> getKarts() {
        return null;
    }

    @Override
    public List<Client> getClients() {
        return null;
    }

    @Override
    public List<DVD> getDVDs() {
        return null;
    }

    public boolean verifyLogin(String user, String password) {
        return false;
    }

    @Override
    public boolean registerKart(Kart kart) {
        return false;
    }

    @Override
    public boolean registerClient(Client client) {
        return false;
    }

    @Override
    public boolean registerDVD(DVD dvd) {
        return false;
    }

}
