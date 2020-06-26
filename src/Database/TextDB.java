package Database;

import Rent.*;
import User.User;
import Util.ConfigOption;
import Util.ConfigReader;
import Util.Hashing;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        }
        catch (Exception exception) {

            exception.printStackTrace();
            
        }

        return true;

    }

    @Override
    public List<User> getUsers() {

        List<User> users = new ArrayList<>();

        try {

            Scanner scanner = new Scanner(new File(usersPath));


            User user;
            String[] line;

            while(scanner.hasNextLine()) {

                line = scanner.nextLine().split(";");
                user = new User(line[0], line[1], Integer.parseInt(line[2]));
                users.add(user);

            }
            scanner.close();

        }
        catch(Exception exception) {

            exception.printStackTrace();
            return null;

        }

        return users;

    }

    @Override
    public List<String> getUsernames() {

        List<String> users = new ArrayList<>();

        try {

            Scanner scanner = new Scanner(new File(usersPath));
            String line;

            while(scanner.hasNextLine()) {

                line = scanner.nextLine();
                line = line.split(";")[0];
                users.add(line);

            }

            scanner.close();

        }
        catch(IOException ex) {

        }

        return users;

    }

    @Override
    public boolean deleteUser(String username) {

        try {

            Scanner scanner = new Scanner(new File(usersPath));

            String user;
            String line;
            ArrayList<String> lines = new ArrayList<>();


            while(scanner.hasNext()) {

                line = scanner.nextLine();
                user = line.split(";")[0];

                if(!username.equals(user))
                    lines.add(line);

            }

            scanner.close();

            FileWriter writer = new FileWriter(new File(usersPath));

            for(String l : lines) {
                System.out.println("Wrote a line");
                writer.write(l+"\n");
            }

            writer.close();

        }
        catch (Exception ex) {

            ex.printStackTrace();
            return false;
        }

        return true;

    }

}
