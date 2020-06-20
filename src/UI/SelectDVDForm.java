package UI;

import Database.Database;
import Rent.DVD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectDVDForm extends JFrame {

    private JPanel root;
    private JButton selectButton;
    private JTable dvdList;
    private JScrollPane scrollPane;

    public SelectDVDForm(NewKartForm kartForm) {

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


        dvdList.setModel(model);

        DefaultTableModel table = (DefaultTableModel) dvdList.getModel();

        dvdList.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.addColumn("Name");
        table.addColumn("Release Date");
        table.addColumn("Price");
        table.addColumn("Serial");

        table.addRow(new String[] {"a", "b", "c", "d"});

        for(DVD dvd : Database.db.getDVDs()) {

            table.addRow(new String[] {dvd.getName(), dvd.getReleaseDate().toString(), String.valueOf(dvd.getPrice()), dvd.getSerial()});

        }

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel table = kartForm.getTable();
                table.addRow(new String[] {dvdList.getValueAt(dvdList.getSelectedRow(), 0).toString(),dvdList.getValueAt(dvdList.getSelectedRow(), 1).toString(),dvdList.getValueAt(dvdList.getSelectedRow(), 2).toString(), dvdList.getValueAt(dvdList.getSelectedRow(), 3).toString()});
                kartForm.update();
            }
        });

    }

}
