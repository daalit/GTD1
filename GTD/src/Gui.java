import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
public class Gui {
    // här vill vi ha all vår GUI kod.
    List<String> postList = new ArrayList<>();
    JFrame frame = new JFrame("Test GUI");
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JPanel postPanel = new JPanel();

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

    public void postList(){
    postPanel.setLayout(new GridLayout(postList.size(), 1));
    postPanel.removeAll();

    for(String post : postList ){
        System.out.println("List test " + post);
        JLabel addPost = new JLabel(post);
        postPanel.add(addPost);

    }
    panel.add(postPanel);
    frame.pack();
    }
 }
