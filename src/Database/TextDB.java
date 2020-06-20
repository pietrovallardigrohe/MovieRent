package Database;

import Rent.*;
import Util.ConfigOption;
import Util.ConfigReader;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TextDB implements IDatabase {

    public TextDB() {

        String path = ConfigReader.read(ConfigOption.Datapath)+"/MovieRentDB";

        new File(path).mkdirs();
        try {
            new File(path + "/Clients.txt").createNewFile();
            new File(path + "/Karts.txt").createNewFile();
            new File(path + "/DVDs.txt").createNewFile();
        }
        catch (IOException ex){

            JOptionPane.showMessageDialog(null, ex.getMessage() + " " + ConfigReader.read(ConfigOption.Datapath));

        }
    }

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
        return true;
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

}
