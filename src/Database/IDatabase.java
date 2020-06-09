package Database;

import Rent.*;
import java.util.List;

public interface IDatabase {


    public List<Kart> getKarts();
    public List<Client> getClients();
    public List<DVD> getDVDs();

}
