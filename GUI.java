package lifeguardScheduler;


import java.awt.BorderLayout;
import static javax.swing.ScrollPaneConstants.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
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
    	employeeFile file = new employeeFile("Employee.txt");
    	schedule schedule = new schedule();

    	//option panes to get start date and end date
    	
    	String month = JOptionPane.showInputDialog("Please Enter the Month of the first day of the period");
    	String startTemp = JOptionPane.showInputDialog("Please Input the first day of the pay period");
    	String endTemp = JOptionPane.showInputDialog("Please enter the last day of the period");
    	
    	
    	int start = Integer.parseInt(startTemp);
    	int end = Integer.parseInt(endTemp);
    	
    	schedule.createEmployeeLists(file);
		try {
			schedule.checkAvailability(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		schedule.generateSchedule(start, end, month);
		schedule.generatePoolSchedule();
		
		//createing JFrame
		JFrame frame = new JFrame("Schedule");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        
        //creating text pane
        JTextArea scheduleText = new JTextArea(500, 500);
        
        
        //creating ScrollPane
        JScrollPane scroll = new JScrollPane(scheduleText);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        //adding scroll pane
        int vericalPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
        scroll.setVerticalScrollBarPolicy(vericalPolicy);
        scroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        frame.getContentPane().add(scroll);
        //frame.add(scroll, BorderLayout.LINE_START); //Adds the lifeguard list to the left side
        
        
		for(day d : lifeguardScheduler.schedule.daysInPeriod) {
			scheduleText.append("" + Integer.toString(d.name) + "\n");
			//System.out.println(d.name);
			//System.out.println("---------------------");
			scheduleText.append("---------------------\n");
			//System.out.println("LIFEGUARDS:");
			scheduleText.append("LIFEGUARDS: \n");
			for (lifeguard l : d.guardsOnDay) {
				scheduleText.append("" + l.name + "\n");
				//System.out.println(l.name);
			}
			//System.out.println("SENIOR GUARDS:");
			scheduleText.append("SENIOR GUARDS: \n");
			for (seniorGuard sg : d.sgOnDay) {
				scheduleText.append("" + sg.name + "\n");
				//System.out.println(sg.name);
			}
			//System.out.println("GATE:");
			scheduleText.append("GATE: \n");
			for (gateGuard g : d.gateOnDay) {
				scheduleText.append("" + g.name + "\n");
				//System.out.println(g.name);
			}
			//System.out.println("GROUNDS: ");
			scheduleText.append("GROUNDS: \n");
			for (grounds g : d.groundsOnDay) {
				scheduleText.append("" + g.name + "\n");
				//System.out.println(g.name);
			}
			//System.out.println("---------------------");
			scheduleText.append("---------------------\n");
			scheduleText.append("POOL: \n");
			//System.out.println("POOL:");
			scheduleText.append("POOL SENIOR GUARDS: \n");
			//System.out.println("POOL SENIOR GUARDS: ");
			for(poolSeniorGuard psg : d.poolSGOnDay) {
				scheduleText.append("" + psg.name + "\n");
				//System.out.println(psg.name);
			}
			//System.out.println("LIFEGUARDS: ");
			scheduleText.append("LIFEGUARDS: \n");
			for(lifeguard lg : d.guardsAtPool) {
				scheduleText.append("" + lg.name + "\n");
				//System.out.println(lg.name);
			}
			scheduleText.append("---------------------\n");
			//System.out.println("---------------------");
		}
    	
        frame.setVisible(true);
       
    }
}
