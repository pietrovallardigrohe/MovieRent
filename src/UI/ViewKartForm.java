package UI;

import Database.Database;
import Rent.DVD;
import Rent.Kart;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewKartForm extends JFrame {

    private JPanel root;
    private JTable dvdsTable;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel cpfLabel;

    public ViewKartForm(Kart kart) {

        setContentPane(root);
        setSize(600, 400);
        setVisible(true);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-this.getSize().height/2 );

        nameLabel.setText(kart.getClient().getName());
        ageLabel.setText(String.valueOf(kart.getClient().getAge()));
        cpfLabel.setText(kart.getClient().getCPF());

        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int i, int i1) {

                return false;

            }

        };

        dvdsTable.setModel(model);

        DefaultTableModel table = (DefaultTableModel) dvdsTable.getModel();

        dvdsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.addColumn("Name");
        table.addColumn("Price");
        table.addColumn("Release Date");
        table.addColumn("Serial");

        for(DVD dvd : kart.getProducts()) {

            table.addRow(new String[] {dvd.getName(), String.valueOf(dvd.getPrice()), dvd.getReleaseDate().toString(), dvd.getSerial()});

        }

    }

}
