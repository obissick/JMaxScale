/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmaxscale;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author obissick
 */
public class JMaxScale {

    /**
     * @param args the command line arguments
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException{
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                double width = screenSize.getWidth();
                double height = screenSize.getHeight();
                JFrame frame = new JFrame("JMaxScale");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //frame.setResizable(false);
                frame.setIconImage(new ImageIcon(getClass().getResource("/lib/icon.png")).getImage());
                frame.getContentPane().add(new ui());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
