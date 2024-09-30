import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui {
    // här vill vi ha all vår GUI kod.
    JFrame frame = new JFrame("Test GUI");
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    
    public Gui(){
    
    JButton newTaskBtn = new JButton("New Task");

    JTextField newTaskTextField = new JTextField();

    // panelen ska ha ett utseende
    
    panel.setLayout(new GridLayout(4,1));
    panel.add(label);
    panel.add(newTaskBtn);
    panel.add(newTaskTextField);

    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

    
    }
    

   // frame.add(panel);

}
