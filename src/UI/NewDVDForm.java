package UI;

import javax.swing.*;
import Database.Database;
import Exceptions.DateNotRecognizedException;
import Rent.DVD;
import Util.DateReader;

import java.time.LocalDate;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class NewDVDForm extends JFrame {

    private JPanel root;
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel releaseDateLabel;
    private JLabel serialLabel;
    private JTextField priceField;
    private JTextField nameField;
    private JTextField serialField;
    private JTextField releaseDateField;
    private JButton newDVDButton;

    public NewDVDForm() {

        setContentPane(root);
        setVisible(true);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-this.getSize().height/2 );
        setSize(500,400);

        newDVDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Database.db.registerDVD(new DVD(nameField.getText(), Double.parseDouble(priceField.getText()), DateReader.readDate(releaseDateField.getText()), serialField.getText()));
                }
                catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Price invalid");
                }
                catch (DateNotRecognizedException ex) {
                    ex.sendMessage();
                }

            }

        });

    }


}
