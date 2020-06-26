package UI;

import Database.Database;
import Util.Hashing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class LoginForm extends JFrame {

    private JPanel root;
    private JTextField loginField;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JButton signinButton;
    private JPasswordField passwordField;

    public LoginForm() {

        setContentPane(root);
        setSize(400,300);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-this.getSize().height/2 );

        signinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(Database.db.verifyLogin(loginField.getText(), Hashing.hash(passwordField.getPassword()))) {

                    setVisible(false);
                    new MainForm();

                }
                else {
                    JOptionPane.showMessageDialog(null, "User or password incorrect");
                }

            }
        });

    }

}
