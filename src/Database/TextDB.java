package Database;

import Rent.*;
import Util.ConfigOption;
import Util.ConfigReader;
import Util.Hashing;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextDB implements IDatabase {

    String path = ConfigReader.read(ConfigOption.Datapath)+"/MovieRentDB";
    String usersPath = path + "/Users.txt";
    String dvdsPath = path + "/DVDs.txt";
    String kartsPath = path + "/Karts.txt";
    String clientsPath = path + "/Clients.txt";

    public TextDB() {

        new File(path).mkdirs();
        try {
            new File(clientsPath).createNewFile();
            new File(kartsPath).createNewFile();
            new File(dvdsPath).createNewFile();
            new File(usersPath).createNewFile();
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

    @Override
    public boolean registerUser(String username, String password, int securityLevel) {

        try {
            FileWriter writer = new FileWriter(usersPath, true);
            writer.write(String.format("%s;%s;%d\n", username, Hashing.hash(password), securityLevel));
            writer.close();
            System.out.println("Wrote");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return true;

    }

    @Override
    public List<String> getUsernames() {
        List list = new ArrayList();
        list.add("a");
        return list;
    }

    @Override
    public void deleteUser(String username) {

    }

}
