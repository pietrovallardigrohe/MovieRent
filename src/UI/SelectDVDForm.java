package UI;

import Database.Database;
import Rent.DVD;
import Util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectDVDForm extends JFrame {

    private JPanel root;
    private JButton selectButton;
    private JTable dvdList;
    private JScrollPane scrollPane;

    public SelectDVDForm(NewKartForm kartForm) {

        setContentPane(root);
        setSize(600, 400);
        setVisible(true);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-this.getSize().height/2 );

        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int i, int i1) {

                return false;

            }

        };


        dvdList.setModel(model);

        DefaultTableModel table = (DefaultTableModel) dvdList.getModel();

        dvdList.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.addColumn("Name");
        table.addColumn("Price");
        table.addColumn("Release Date");
        table.addColumn("Serial");

        for(DVD dvd : Database.db.getDVDs()) {

            table.addRow(new String[] {dvd.getName(), String.valueOf(dvd.getPrice()), dvd.getReleaseDate().toString(), dvd.getSerial()});

        }

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    kartForm.getTable().addRow(new String[] {table.getValueAt(dvdList.getSelectedRow(), 0).toString(), table.getValueAt(dvdList.getSelectedRow(), 1).toString(), table.getValueAt(dvdList.getSelectedRow(), 2).toString(), table.getValueAt(dvdList.getSelectedRow(), 3).toString()});
                    kartForm.dvds.add(new DVD(table.getValueAt(dvdList.getSelectedRow(), 0).toString(), Double.parseDouble(table.getValueAt(dvdList.getSelectedRow(), 1).toString()), Date.readDate(table.getValueAt(dvdList.getSelectedRow(), 2).toString()), table.getValueAt(dvdList.getSelectedRow(), 3).toString()));

                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "DVD initialization error");
                }

            }
        });

    }

}
