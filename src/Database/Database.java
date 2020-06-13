package Database;

import Util.ConfigOption;
import Util.ConfigReader;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Database {

    public static IDatabase db = define(ConfigReader.read(ConfigOption.Database));

    private static IDatabase define(String database) {

        switch(database) {

            case "TEXT" : return new TextDB();
            case "ORACLE" : return new OracleSQL();
            default: throw new DatabaseNotRecognizedException(database);

        }

    }



}
