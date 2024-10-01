import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JCheckBox;

public class Gui {
    // här vill vi ha all vår GUI kod.
    List<String> postList = new ArrayList<>();
    JFrame frame = new JFrame("Test GUI");
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JLabel label2 =new JLabel();
    JPanel postPanel = new JPanel();
    JPanel checkbox = new JPanel();
   
    public Gui(){

    JTextField newTaskTextField = new JTextField();
    JButton newTaskBtn = new JButton("New Task");
        newTaskBtn.addActionListener(e ->{
            getPostText(newTaskTextField.getText());
        });

   /*  JButton fetchBtn = new JButton("Fånga skiten");
        fetchBtn.addActionListener(e ->{
            getPostText(null);
        });*/

    

    // panelen ska ha ett utseende

    panel.setLayout(new GridLayout(3,3));
    panel.add(label);
    panel.add(newTaskBtn);
    panel.add(newTaskTextField);
    panel.add(label2);
    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);


    }
    public void marklist(){
        checkbox.setLayout(new GridLayout(postList.size(),3));
        JCheckBox c1 = new JCheckBox("Markera som klar"); 
        panel.add(c1);
        panel.add(checkbox);
        frame.pack();

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
    marklist();
    frame.pack();
    }

    public void getPostText(String insert){
        
        
        
        
        postList.add(insert);
        System.out.println(postList);
        postList();
        
     }

     
 }

