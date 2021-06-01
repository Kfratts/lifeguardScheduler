package lifeguardScheduler;

import java.util.*; 
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;




public class employeeFile {
	public static void createFileAndInitialize(){
		try {
			File employeeFile = new File("C:\\Users\\18452\\cs140\\eclipse\\cs140\\src\\lifeguardScheduler\\employeeFiles\\employee.text");
			if(employeeFile.exists()) {
				System.out.println("File already exists, we will use this file");
			}
			else {
				Scanner s = new Scanner(System.in); 
				//create file
				employeeFile.createNewFile();
				System.out.println("Created an employee file to track employees");
				//create file writer
				FileWriter writer = new FileWriter(employeeFile);
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
}
