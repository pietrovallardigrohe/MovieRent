package UI;

import Rent.Kart;
import Database.Database;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.DirectoryNotEmptyException;

import static javax.swing.text.StyleConstants.Size;

public class MainForm extends JFrame{

    private JTable openRentsTable;
    private JPanel root;
    private JButton newKartButton;
    private JButton newClientButton;
    private JScrollPane scrollPane;
    private JButton manageUsersButton;
    private JButton newDVDButton;
    private JButton viewKartButton;

    public MainForm(int security) {

        setContentPane(root);
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-this.getSize().height/2 );
        manageUsersButton.setVisible(false);

        if(security == 1)
            manageUsersButton.setVisible(true);

        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int i, int i1) {

                return false;

            }

        };

        openRentsTable.setModel(model);

        DefaultTableModel table = (DefaultTableModel) openRentsTable.getModel();

        openRentsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.addColumn("Id");
        table.addColumn("Name");
        table.addColumn("Value");
        table.addColumn("Due");

        update();

        newClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new NewClientForm();

            }
        });

        newDVDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new NewDVDForm();

            }
        });

        newKartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewKartForm(MainForm.this);
            }
        });

        manageUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManageUsersForm();
            }
        });

        viewKartButton.addActionListener(e -> {

            new ViewKartForm(Database.db.getKartById(Integer.parseInt(table.getValueAt(openRentsTable.getSelectedRow(), 0).toString())));

        });

    }

    public void update() {

        DefaultTableModel table = (DefaultTableModel) openRentsTable.getModel();

        for(int i = 0; i < table.getRowCount(); i++) {
            table.removeRow(i);
        }

        for(Kart kart : Database.db.getKarts()) {

            table.addRow(new String[] {String.valueOf(kart.getId()), kart.getClient().getName(), String.valueOf(kart.getValue()), kart.getDueDate().toString()});

        }

    }

}
