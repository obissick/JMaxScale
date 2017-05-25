/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmaxscale;

/**
 *
 * @author obissick
 */
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditConfGUI extends JFrame{   

    public EditConfGUI(){
        fileRead();
        panels();         
    }

    private String storeAllString="";
    private JButton saveCloseBtn = new JButton("Save Changes and Close");
    private JButton closeButton = new JButton("Exit Without Saving");
    private JFrame frame=new JFrame("Viewing All Program Details");
   // private JTextArea textArea = new JTextArea(storeAllString,0,70);
    private JTextArea textArea = new JTextArea();


    private JButton getCloseButton(){
        return closeButton;
     }     

    private void fileRead(){
        TransferFile ssh = new TransferFile(); 
        ssh.download("MaxScale.cnf", ui.getHost(), ui.getUser(), ui.getPass());
        try{    
          FileReader read = new FileReader("MaxScale.cnf");
          Scanner scan = new Scanner(read);
             while(scan.hasNextLine()){
              String temp=scan.nextLine()+"\n";
              storeAllString=storeAllString+temp;
             }
             textArea.setText(storeAllString);
      }
        catch (Exception exception)
         {
         exception.printStackTrace();
         }
    }      



    private void panels(){        
         JPanel panel = new JPanel(new GridLayout(1,1));
         panel.setBorder(new EmptyBorder(5, 5, 5, 5));
         JPanel rightPanel = new JPanel(new GridLayout(15,0,10,10));
         rightPanel.setBorder(new EmptyBorder(15, 5, 5, 10));
        // JTextArea textArea = new JTextArea(storeAllString,0,70);
          JScrollPane scrollBarForTextArea=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          panel.add(scrollBarForTextArea); 
          frame.add(panel);
         frame.getContentPane().add(rightPanel,BorderLayout.EAST);
         rightPanel.add(saveCloseBtn);
          rightPanel.add(closeButton);
          closeButton.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e)
                    {
                        frame.dispose();

                    }
        });
          saveCloseBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                saveBtn();
                frame.dispose();

            }
        });
           frame.setSize(1000, 700);
           frame.setVisible(true);   
           frame.setLocationRelativeTo(null);

}

    private void saveBtn(){
        File file = null;
        FileWriter out=null;


        try {
            file = new File("MaxScale.cnf");
            out = new FileWriter(file);     
            out.write(textArea.getText());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
  }
    public static void main(String[] arg)
    {
        new EditConfGUI();
    }
}