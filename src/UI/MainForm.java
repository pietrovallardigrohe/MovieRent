package UI;

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

    public MainForm() {

        setContentPane(root);
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-this.getSize().height/2 );

        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int i, int i1) {

                return false;

            }

        };

        openRentsTable.setModel(model);

        DefaultTableModel table = (DefaultTableModel) openRentsTable.getModel();

        openRentsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.addColumn("Name");
        table.addColumn("Value");
        table.addColumn("Due");

        table.addRow(new String[] {"a","ab","bc"});

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



    }

}
