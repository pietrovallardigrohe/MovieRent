package UI;

import Database.DB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
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

//                DB.db.verifyLogin(loginField.getText(), hash(passwordField.getPassword().toString()));
                System.out.println(hash(passwordField.getPassword().toString()));

            }
        });

    }

    private String hash(String word) {


        if(word.trim() != "") {

            try {
                //Fail
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] result = digest.digest(word.getBytes(StandardCharsets.UTF_8));
                System.out.println(Base64.getEncoder().encodeToString(result));
            }
            catch (Exception ex) {
                ex.getStackTrace();
            }

        }

        return null;

    }

}
