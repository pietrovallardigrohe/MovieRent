package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Database.Database;
import User.User;

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

        updateTable();

        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new NewUserForm(ManageUsersForm.this);

            }

        });

        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Database.db.deleteUser(table.getValueAt(usersTable.getSelectedRow(), 0).toString());
                    updateTable();
                }
                catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "An user must be selected");
                }

            }

        });

    }

    void updateTable() {

        DefaultTableModel table = (DefaultTableModel) usersTable.getModel();

        table.setRowCount(0);
        for(User user : Database.db.getUsers()) {

            table.addRow(new String[] {user.getUsername(), user.getPassword(), String.valueOf(user.getSecurityLevel())});

        }

    }

}
