import Database.Database;
import UI.LoginForm;
import Database.IDatabase;

public class Main {

    public static void main(String[] args) {

        IDatabase db = Database.db;

        new LoginForm();

    }

}
