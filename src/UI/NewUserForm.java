package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Database.Database;
import Util.Hashing;

import java.util.List;

public class NewUserForm extends JFrame {

    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JTextField passwordField;
    private JComboBox securityBox;
    private JLabel securityLabel;
    private JButton enterButton;
    private JPanel root;

    public NewUserForm(ManageUsersForm parent) {

        setContentPane(root);
        setSize(800, 600);
        setVisible(true);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-this.getSize().height/2 );

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    List<String> users = Database.db.getUsernames();
                    if(users.contains(usernameField.getText()))
                        throw new Exception();
                    if(usernameField.getText().trim().length() == 0 || passwordField.getText().trim().length() == 0)
                        throw new Exception();
                    Database.db.registerUser(usernameField.getText(), Hashing.hash(passwordField.getText().toCharArray()), securityBox.getSelectedIndex());

                    parent.updateTable();

                    dispose();

                }
                catch (Exception exception) {

                    JOptionPane.showMessageDialog(null, "Username Not Unique or a field is empty");

                }

            }

        });

    }

}
