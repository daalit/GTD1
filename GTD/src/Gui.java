


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Dimension;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.GridLayout;


public class Gui {
    // här vill vi ha all vår GUI kod.
    DefaultListModel<String> taskListModel = new DefaultListModel<>();
    DefaultListModel<String> historyListModel = new DefaultListModel<>();
    JList<String> taskList = new JList<>(taskListModel);
    JList<String> historyList = new JList<>(historyListModel);
    
 
    JFrame frame = new JFrame("To do List");
    JPanel listPanel = new JPanel();
    JLabel label = new JLabel("To do");
    JLabel label2 =new JLabel("Done");
    JPanel inputPanel = new JPanel();
    JPanel labelPanel = new JPanel();
    JPanel btnPanel = new JPanel();
    JPanel mainBoxPanel = new JPanel();


    public Gui(){

      JTextField newTaskTextField = new JTextField();
      newTaskTextField.setPreferredSize(new Dimension(600, 120));
      JButton newTaskBtn = new JButton("New Task");

        newTaskBtn.addActionListener(e ->{
            getPostText(newTaskTextField.getText());
        });

    JButton moveTaskBtn = new JButton("Done");

    moveTaskBtn.addActionListener(e -> {
      moveFunction();
    });

    JButton deleteTaskBtn = new JButton("Delete");
    deleteTaskBtn.addActionListener(e -> {
      deleteFunction();

    });
       //Box test
    BoxLayout mainBoxLayout = new BoxLayout(mainBoxPanel, BoxLayout.Y_AXIS);
    mainBoxPanel.setLayout(mainBoxLayout);

    mainBoxPanel.add(labelPanel);
    mainBoxPanel.add(listPanel);
    mainBoxPanel.add(inputPanel);
    mainBoxPanel.add(btnPanel);

       //Header Label
    labelPanel.setLayout(new FlowLayout());
    labelPanel.setPreferredSize(new Dimension(120, 100));
    labelPanel.add(label);
    labelPanel.add(label2);
    labelPanel.setBorder(new EmptyBorder(40, 0, 0, 0));
    label.setBorder(new EmptyBorder(0, 0, 0, 300));
       //Listor
    listPanel.setLayout(new GridLayout());
    listPanel.setPreferredSize(new Dimension(120, 500));
    listPanel.setBackground(Color.yellow);
    listPanel.add(taskList);
    listPanel.add(historyList);
    taskList.setBorder(new LineBorder(Color.red, 2));
    historyList.setBorder(new LineBorder(Color.red, 2));
      //Input textfält + knapp
    
    inputPanel.setLayout(new FlowLayout());
    inputPanel.add(newTaskTextField);
    inputPanel.add(newTaskBtn);

    btnPanel.setPreferredSize(new Dimension(100, 100));
    btnPanel.setLayout(new FlowLayout());
    btnPanel.add(Box.createRigidArea(new Dimension(5, 5)));
    btnPanel.add(moveTaskBtn);
    btnPanel.add(deleteTaskBtn);
    deleteTaskBtn.setSize(new Dimension(100,20));
    moveTaskBtn.setSize(new Dimension(100,20));
    
    frame.setBackground(Color.yellow);
    frame.setBounds(20, 20, 100, 100);
    frame.add(mainBoxPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setSize(800,800);
    frame.setVisible(true);

    }


    

    //Ej rört
        public void getPostText(String insert){
                                
        taskListModel.addElement(insert);
        System.out.println(taskListModel);
        
      
        
     }

     public void moveFunction (){
      int selectedIndex = taskList.getSelectedIndex();
      int selectedHistoryIndex = historyList.getSelectedIndex();
    

      if(selectedIndex != -1){
        String selectedTask = taskList.getSelectedValue();
       

        taskListModel.removeElementAt(selectedIndex);
        historyListModel.addElement(selectedTask);
       
        System.out.println(historyList);

      } else if( selectedHistoryIndex != -1){
       
        String selectedHistory = historyList.getSelectedValue();

        historyListModel.removeElementAt(selectedHistoryIndex);
        taskListModel.addElement(selectedHistory);
    
        System.out.println(taskList);
        
      }

     } 

     public void deleteFunction (){
      int selectedIndex = taskList.getSelectedIndex();
      int historyIndex = historyList.getSelectedIndex();

      System.out.println(selectedIndex);
        if (selectedIndex >= 0) {
          taskListModel.removeElementAt(selectedIndex);
          
        }else if (historyIndex >=0){
          historyListModel.removeElementAt(historyIndex);

        }


    }
 }

