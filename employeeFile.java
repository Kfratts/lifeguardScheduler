package lifeguardScheduler;

import java.util.*; 
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.awt.Desktop;  




public class employeeFile {
	public static void createFileAndInitialize(){
		try {
			File file = new File("C:\\Users\\18452\\cs140\\eclipse\\cs140\\src\\lifeguardScheduler\\employeeFiles\\employee.text");
			if(file.exists()) {
				System.out.println("File already exists, would you like to edit this file?");
				System.out.println("If so, type 'yes', if not then type 'no'");
				Scanner s = new Scanner(System.in); 
				String answer = s.nextLine(); 
				if(answer.toUpperCase().equals("YES")) {
					employeeFile.editFile("C:\\Users\\18452\\cs140\\eclipse\\cs140\\src\\lifeguardScheduler\\employeeFiles\\employee.text");
				}
			}
			else {
				Scanner s = new Scanner(System.in); 
				//create file
				file.createNewFile();
				System.out.println("Created an employee file to track employees");
				//create file writer
				FileWriter writer = new FileWriter(file);
				//create print writer
				PrintWriter pw = new PrintWriter(writer);
				//write to file
				pw.println("LIFEGUARDS:");
				System.out.println("Add Lifeguards to the file, when Finished, type DONE");
				while(true) {
					String input = s.nextLine();
					if (input.trim().equalsIgnoreCase("done")) {
		                System.out.println("Added Lifeguards to file");
		                break;
		            }
					pw.println(input);
				}
				System.out.println("Add Senior Guards to File");
				pw.println("");
				pw.println("SENIOR GUARDS:");
				pw.println("");
				while(true) {
					String input = s.nextLine();
					if (input.trim().equalsIgnoreCase("done")) {
		                System.out.println("Added Senior guards to file");
		                break;
		            }
					pw.println(input);
				}
				System.out.println("Add Gate Guards to File");
				pw.println("");
				pw.println("GATE GUARDS:");
				pw.println("");
				while(true) {
					String input = s.nextLine();
					if (input.trim().equalsIgnoreCase("done")) {
		                System.out.println("Added Gate Guards to file");
		                break;
		            }
					pw.println(input);
				}
				System.out.println("Add Grounds to File");
				pw.println("");
				pw.println("GROUNDS:");
				pw.println("");
				while(true) {
					String input = s.nextLine();
					if (input.trim().equalsIgnoreCase("done")) {
		                System.out.println("Added Grounds to file");
		                break;
		            }
					pw.println(input);
				}
				
				
				pw.close();
				s.close();
			}
		}catch (IOException e) {
			System.out.println("Unable to generate a file");
		}
	}
	
	public static void editFile(String filePath) {
		try {
			File file = new File(filePath);
			try {
				Desktop desktop = Desktop.getDesktop();
				if(file.exists()) {
					desktop.open(file);
				}
				}catch(Exception e){
					System.out.println("This action is not supported!");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}

