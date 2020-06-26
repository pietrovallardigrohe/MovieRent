package Database;

import Rent.Client;
import Rent.DVD;
import Rent.Kart;
import User.User;

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

    @Override
    public List<User> getUsers() {
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

    @Override
    public int getKartId() {
        return 0;
    }

    @Override
    public boolean registerUser(String username, String password, int securityLevel) {
        return false;
    }

    @Override
    public List<String> getUsernames() {
        return null;
    }

    @Override
    public boolean deleteUser(String username) {
        return false;
    }

}
