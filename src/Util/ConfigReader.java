package Util;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {

    public static String read(ConfigOption option) {

        String result = null;

        try {

            BufferedReader reader = new BufferedReader(new FileReader("src/config"));

            String line = reader.readLine();
            while(line != null) {

                if(!line.startsWith("--")) {

                    if(option == ConfigOption.Database) {
                        String pattern = "^database:\\s";
                        if(line.startsWith("database:")) {
                            result = line.replaceAll(pattern, "");
                            return result.replace('\"', ' ').toUpperCase().trim();
                        }
                    }
                    else if(option == ConfigOption.DataPath) {

                        String pattern = "^datapath:\\s";
                        if(line.startsWith("datapath:")) {
                            result = line.replaceAll(pattern, "");
                            result = result.replace('\"', ' ').toUpperCase().trim();
                            return result.replace('\\', '/');
                        }
                    }

                }

                line = reader.readLine();

            }

        }
        catch(IOException exception) {

            JOptionPane.showMessageDialog(null,exception.toString());

        }

        return "UNKNOWN";

    }

}
