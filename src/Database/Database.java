package Database;

import Exceptions.DatabaseNotRecognizedException;
import Util.ConfigOption;
import Util.ConfigReader;

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
