package lifeguardScheduler;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.io.FileWriter;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class GUI{
    public static void main(String args[]){
       JFrame frame = new JFrame("Lifeguard Scheduler");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(700,700);
       JTextArea lifeguards = new JTextArea(10, 10);
       JTextField lifeguardTitle = new JTextField("Lifeguard List:"); 
       frame.add(lifeguardTitle, BorderLayout.PAGE_START); 
       frame.add(lifeguards, BorderLayout.LINE_START); //Adds the lifeguard list to the left side
      
       //Saves the lifeguards in the list to a file
       JButton save = new JButton("Save Lifeguard List");
       frame.add(save, BorderLayout.PAGE_END);
       
       frame.setVisible(true);
       
    }
}
