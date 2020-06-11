package UI;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame{

    private JTable openRentsTable;
    private JPanel root;
    private JButton button1;
    private JButton button2;

    public MainForm() {

        setContentPane(root);
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-this.getSize().height/2 );


    }

}
