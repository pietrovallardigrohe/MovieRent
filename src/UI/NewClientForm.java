package UI;

import Database.Database;
import Rent.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewClientForm extends JFrame {

    private JPanel root;
    private JTextField ageField;
    private JButton registerClientButton;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JTextField nameField;
    private JLabel cpfLabel;
    private JTextField cpfField;

    public NewClientForm() {

        setContentPane(root);
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-this.getSize().height/2 );
        setVisible(true);

        registerClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    Database.db.registerClient(new Client(Long.getLong(cpfField.getText().trim()), nameField.getText(), Integer.getInteger(ageField.getText().trim())));

                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "There is an invalid field");
                }

            }

        });

    }

}
