package UI;

import Database.Database;
import Rent.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectClientForm extends JFrame {

    private JPanel root;
    private JTable clientList;
    private JButton selectButton;

    public SelectClientForm(NewKartForm kartForm) {

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


        clientList.setModel(model);

        DefaultTableModel table = (DefaultTableModel) clientList.getModel();

        clientList.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.addColumn("Name");
        table.addColumn("CPF");
        table.addColumn("Age");

        table.addRow(new String[] {"a","ab","2"});

        for(Client client : Database.db.getClients()) {

            table.addRow(new String[] {client.getName(), client.getCPF(), String.valueOf(client.getAge())});

        }

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewKartForm.client = new Client(table.getValueAt(clientList.getSelectedRow(), 0).toString(), table.getValueAt(clientList.getSelectedRow(), 1).toString(), Integer.parseInt(table.getValueAt(clientList.getSelectedRow(), 2).toString()));
                kartForm.update();
            }
        });

    }

}
