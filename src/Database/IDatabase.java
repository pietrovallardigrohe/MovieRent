package Database;

import Rent.*;
import Rent.User;

import java.util.List;

public interface IDatabase {


    List<Kart> getKarts();
    List<Client> getClients();
    List<DVD> getDVDs();


    boolean registerKart(Kart kart);
    boolean registerClient(Client client);
    boolean registerDVD(DVD dvd);

    int getKartId();

    Client getClientByCPF(String cpf);

    int verifyLogin(String user, String password);
    boolean registerUser(String username, String password, int securityLevel);
    List<User> getUsers();
    List<String> getUsernames();
    boolean deleteUser(String username);

    Kart getKartById(int id);

}
