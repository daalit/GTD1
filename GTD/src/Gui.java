

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;


public class Gui {
    // här vill vi ha all vår GUI kod.
 
    JFrame frame = new JFrame("Test GUI");
    JPanel panel = new JPanel();
  //  JLabel label = new JLabel("Testtext");
    //JLabel label2 =new JLabel("Testtext 2");
    JPanel postPanel = new JPanel();
    JPanel checkbox = new JPanel();
    DefaultListModel<String> taskListModel = new DefaultListModel<>();
    DefaultListModel<String> historyListModel = new DefaultListModel<>();
    JList<String> taskList = new JList<>(taskListModel);
    JList<String> historyList = new JList<>(historyListModel);


    public Gui(){

    JTextField newTaskTextField = new JTextField();
    JButton newTaskBtn = new JButton("New Task");
        newTaskBtn.addActionListener(e ->{
            getPostText(newTaskTextField.getText());
        });

    
    JButton deleteTaskBtn = new JButton("Delete");
    
    JButton moveTaskBtn = new JButton("move");

    moveTaskBtn.addActionListener(e -> {
      int selectedIndex = taskList.getSelectedIndex();
      if(selectedIndex != -1){
        String selectedTask = taskList.getSelectedValue();
        taskListModel.removeElementAt(selectedIndex);
        historyListModel.addElement(selectedTask);
        System.out.println(historyList);
      }
    });


    deleteTaskBtn.addActionListener(e -> {
      int selectedIndex = taskList.getSelectedIndex();
      System.out.println(selectedIndex);
        if (selectedIndex >= 0) {
          taskListModel.removeElementAt(selectedIndex);
          
        }
    });
       
    // panelen ska ha ett utseende

    panel.setLayout(new GridLayout(4,1));
   // panel.add(label);
    panel.add(newTaskBtn);
    panel.add(newTaskTextField);
    panel.add(deleteTaskBtn);
    panel.add(moveTaskBtn);
   // panel.add(label2);
    panel.add(taskList);
    panel.add(historyList);
    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
  
    frame.setVisible(true);

    }

             
        public void getPostText(String insert){
                                
        taskListModel.addElement(insert);
        System.out.println(taskListModel);
        
      
        
     }

     
 }

