package UI;

import Database.DB;
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

                if(DB.db.verifyLogin(loginField.getText(), hash(passwordField.getPassword()))) {

                    setVisible(false);
                    new MainForm();

                }
                else {
                    JOptionPane.showMessageDialog(null, "User or password incorrect");
                }

            }
        });

    }

    private String hash(char[] word) {

        StringBuilder sb = new StringBuilder();
        for(char c : word) {
            sb.append(c);
        }
        String password = sb.toString();


        if(password.trim() != "") {

            try {

                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] result = md.digest(password.getBytes(StandardCharsets.UTF_8));
                return Base64.getEncoder().encodeToString(result);

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }


        }

        return null;

    }

}
