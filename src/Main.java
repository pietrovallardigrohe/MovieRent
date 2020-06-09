import Database.IDatabase;
import UI.LoginForm;

public class Main {

    public static void main(String[] args) {

        IDatabase db = Database.DB.db;

        new LoginForm();

    }

}
