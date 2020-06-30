package Database;

import Rent.*;
import Rent.User;
import Util.ConfigOption;
import Util.ConfigReader;
import Util.Date;

import javax.swing.*;
import java.io.*;
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
    public List<Client> getClients() {

        try {

            Scanner scanner = new Scanner(new File(clientsPath));

            String[] line;
            ArrayList<Client> clients = new ArrayList<>();

            while(scanner.hasNext()) {

                line = scanner.nextLine().split(";");
                clients.add(new Client(line[0], line[1], Integer.parseInt(line[2])));

            }

            return clients;

        }
        catch(Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data corrupted");
        }

        return null;

    }

    @Override
    public boolean registerClient(Client client) {

        try {

            FileWriter writer = new FileWriter(clientsPath, true);

            writer.write(client.toString()+"\n");
            writer.close();

            return true;

        }
        catch(Exception ex) {



        }

        return false;

    }

    public Client getClientByCPF(String cpf) {

        try {

            Scanner scanner = new Scanner(new File(clientsPath));

            while(scanner.hasNext()) {

                String[] line = scanner.nextLine().split(";");

                if(line[0].equals(cpf))
                    return new Client(line[0], line[1], Integer.parseInt(line[2]));

            }

        }
        catch(Exception exception) {
            JOptionPane.showMessageDialog(null, "getClientByCPF failed");
        }

        return null;

    }

    @Override
    public List<DVD> getDVDs() {

        try {

            Scanner scanner = new Scanner(new File(dvdsPath));

            List<DVD> dvds = new ArrayList<>();

            while(scanner.hasNext()) {

                String[] line = scanner.nextLine().split(";");
                dvds.add(new DVD(line[0], Double.parseDouble(line[1]), Date.readDate(line[2]), line[3]));

            }

            return dvds;

        }
        catch(Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data corrupted");
        }

        return null;

    }

    @Override
    public boolean registerDVD(DVD dvd) {

        try {

            FileWriter writer = new FileWriter(dvdsPath, true);
            writer.write(dvd.toString()+"\n");
            writer.close();

            return true;

        }
        catch(Exception exception) {
            JOptionPane.showMessageDialog(null, "Unexpected Error");
        }

        return false;

    }

    public DVD getDVDBySerial(String serial) {

        try {

            Scanner scanner = new Scanner(new File(dvdsPath));

            while(scanner.hasNext()) {

                String[] line = scanner.nextLine().split(";");

                if(line[3].equals(serial))
                    return new DVD(line[0], Double.parseDouble(line[1]), Date.readDate(line[2]), line[3]);

            }

        }
        catch(Exception exception) {

        }

        return null;

    }

    @Override
    public List<Kart> getKarts() {

        try {

            Scanner scanner = new Scanner(new File(kartsPath));
            List<Kart> karts = new ArrayList<>();

            while(scanner.hasNext()) {

                String[] line = scanner.nextLine().split(";");

                Kart kart = new Kart(Integer.parseInt(line[0]));

                Client client = getClientByCPF(line[1]);

                if(client != null)
                    kart.setClient(client);
                else
                    throw new Exception();

                List<DVD> dvds = new ArrayList<>();

                for(String serial : line[2].split(",")) {

                    dvds.add(getDVDBySerial(serial));

                }

                kart.setProducts(dvds);
                kart.setDueDate(Date.readDate(line[3]));

                karts.add(kart);

            }

            return karts;

        }
        catch(Exception ex) {

            JOptionPane.showMessageDialog(null, "Kart data corrupted");

        }

        return null;

    }

    @Override
    public int getKartId() {

        try {

            Scanner scanner = new Scanner(new File(kartsPath));

            String[] line = null;

            while(scanner.hasNext()) {

                line = scanner.nextLine().split(";");

            }

            if(line != null)
                return Integer.parseInt(line[0])+1;
            else
                return 0;
        }
        catch(NumberFormatException exception) {
            return 0;
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "getKartId error");
        }

        return -1;

    }

    @Override
    public boolean registerKart(Kart kart) {
        
        try {

            FileWriter writer = new FileWriter(new File(kartsPath), true);

            writer.write(String.format("%d;%s;", kart.getId(), kart.getClient().getCPF()));

            int i = 1;

            for(DVD dvd : kart.getProducts()) {

                if(!(i == kart.getProducts().size())) {

                    writer.write(String.format("%s,", dvd.getSerial()));
                    i++;
                } else {

                    writer.write(String.format("%s;%s\n", dvd.getSerial(), kart.getDueDate().toString()));

                }

            }

            writer.close();

        }
        catch(Exception ex) {
            
        }

        return false;

    }

    @Override
    public boolean registerUser(String username, String password, int securityLevel) {

        try {

            FileWriter writer = new FileWriter(usersPath, true);
            writer.write(String.format("%s;%s;%d\n", username, password, securityLevel));
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

    public int verifyLogin(String user, String password) {

        try {

            Scanner scanner = new Scanner(new File(usersPath));


            while(scanner.hasNext()) {

                String[] line = scanner.nextLine().split(";");
                String lineUser = line[0];
                String linePassword = line[1];
                String lineSecurity = line[2];

                if(user.equals(lineUser) && password.equals(linePassword))
                    return Integer.parseInt(lineSecurity);

            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return -1;

    }

    public Kart getKartById(int id) {

        for(Kart kart : getKarts()) {

            if(kart.getId() == id)
                return kart;

        }

        return null;

    }

}
