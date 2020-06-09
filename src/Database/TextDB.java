package Database;

import Rent.Client;
import Rent.DVD;
import Rent.Kart;
import Util.ConfigOption;
import Util.ConfigReader;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TextDB implements IDatabase {

    public TextDB() {

        String path = ConfigReader.read(ConfigOption.DataPath)+"/MovieRentDB";

        new File(path).mkdirs();
        try {
            new File(path + "/Clients.txt").createNewFile();
            new File(path + "/Karts.txt").createNewFile();
            new File(path + "/DVDs.txt").createNewFile();
        }
        catch (IOException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
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

}
