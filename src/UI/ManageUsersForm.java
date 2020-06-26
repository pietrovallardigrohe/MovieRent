package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Database.Database;

public class ManageUsersForm extends JFrame {

    private JPanel root;
    private JTable usersTable;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JScrollPane scrollPane;

    public ManageUsersForm() {

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

        usersTable.setModel(model);

        DefaultTableModel table = (DefaultTableModel) usersTable.getModel();

        usersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.addColumn("Username");
        table.addColumn("Password");
        table.addColumn("Security Level");

        table.addRow(new String[] {"a","ab","bc"});

        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new NewUserForm();

            }

        });

        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Database.db.deleteUser(table.getValueAt(usersTable.getSelectedRow(), 0).toString());

                table.addRow(new String[] {"a","ab","b1c"});
            }

        });

    }

}
