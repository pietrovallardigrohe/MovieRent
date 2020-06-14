package UI;

import javax.swing.*;
import java.awt.*;

public class NewKartForm extends JFrame {

    private JPanel root;

    public NewKartForm() {

        setContentPane(root);
        setSize(800, 600);
        setVisible(true);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-this.getSize().height/2 );


    }

}
