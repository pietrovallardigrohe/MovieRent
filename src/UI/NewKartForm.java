package UI;

import Rent.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewKartForm extends JFrame {

    private JPanel root;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel cpfLabel;
    private JTable dvdTable;
    private JScrollPane scrollPane;
    private JButton selectClientButton;
    private JButton selectDVDButton;

    public static Client client;
    public static DVD dvd;

    public NewKartForm() {

        NewKartForm thisForm = this;

        setContentPane(root);
        setSize(800, 600);
        setVisible(true);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-this.getSize().height/2 );

        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int i, int i1) {

                return false;

            }

        };

        dvdTable.setModel(model);

        DefaultTableModel table = (DefaultTableModel) dvdTable.getModel();

        dvdTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.addColumn("Name");
        table.addColumn("Release Date");
        table.addColumn("Price");

        table.addRow(new String[] {"a","ab","bc"});

        selectClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectClientForm(thisForm);
            }
        });

        selectDVDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectDVDForm(thisForm);
            }
        });

    }

    public void update() {
        nameLabel.setText(client.getName());
        ageLabel.setText(String.valueOf(client.getAge()));
        cpfLabel.setText(client.getCPF());
    }

    public DefaultTableModel getTable() {
        return (DefaultTableModel) dvdTable.getModel();
    }

    public JTable getDvdTable() {
        return dvdTable;
    }
}
