package UI;

import Rent.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Database.Database;
import Util.Date;

import java.util.ArrayList;
import java.util.List;

public class NewKartForm extends JFrame {

    private JPanel root;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel cpfLabel;
    private JTable dvdTable;
    private JScrollPane scrollPane;
    private JButton selectClientButton;
    private JButton selectDVDButton;
    private JButton registerKartButton;
    private JLabel dvdNameLabel;
    private JLabel dvdReleaseDateLabel;
    private JLabel priceLabel;
    private JButton removeDVDButton;
    private JTextField dueDateField;
    private JLabel dueDateLabel;

    public static Client client;
    public static List<DVD> dvds = new ArrayList<>();

    public NewKartForm(MainForm mainForm) {

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
        table.addColumn("Price");
        table.addColumn("Release Date");

        selectClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectClientForm(NewKartForm.this);
            }
        });

        selectDVDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectDVDForm(NewKartForm.this);
            }
        });

        registerKartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(client != null && dvds.size() > 0)
                        Database.db.registerKart(new Kart(Database.db.getKartId(), client, dvds, Date.readDate(dueDateField.getText())));
                    else
                        JOptionPane.showMessageDialog(null, "There must be a client and a dvd");
                    mainForm.update();

                }
                catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Unexpected error");
                    exception.printStackTrace();
                }

            }
        });

        removeDVDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dvds.remove(dvdTable.getSelectedRow());
                table.removeRow(dvdTable.getSelectedRow());
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
