package UI;

import javax.swing.*;
import java.awt.*;

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



    }

}
