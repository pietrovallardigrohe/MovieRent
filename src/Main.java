import Database.Database;
import Database.IDatabase;
import UI.LoginForm;

public class Main {

    public static void main(String[] args) {

        IDatabase db = Database.db;

        new LoginForm();

    }

}
