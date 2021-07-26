package lifeguardScheduler;

import java.util.*; 

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.awt.Desktop;  

public class employeeFile {
	public static void createFileAndInitialize(){
		String path = "C:\\Users\\18452\\cs140\\eclipse\\src\\Lifeguard_Scheduler\\src\\lifeguardScheduler\\employee.text";
		try {
			File file = new File(path);
			if(file.exists()) {
				System.out.println("File already exists, would you like to edit this file?");
				System.out.println("If so, type 'yes', if not then type 'no'");
				@SuppressWarnings("resource")
				Scanner s = new Scanner(System.in); 
				String answer = s.nextLine(); 
				if(answer.toUpperCase().equals("YES")) {
					employeeFile.editFile(path);
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
	public static List<String> getLifeguards(String filePath) {
		File file = new File(filePath);
		List<String> guardList = new ArrayList<String>();
		try {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(file).useDelimiter(",\\s*");
			String token;
			//List<String> lifeguardList = new ArrayList<String>();
			List<String> temp = new ArrayList<String>();
			while(s.hasNextLine()) {
				token = s.nextLine().trim();
				if (token.contains("SENIOR GUARDS:")) {
					break;
				}
				temp.add(token);
					
			}
			guardList = temp;
		} catch(Exception e){
			System.out.println("Error getting file!");
		}
		for (Iterator<String> iterator = guardList.iterator(); iterator.hasNext();) {
		    String sNext = iterator.next();
		    if(sNext == "") {
		        iterator.remove();
		    }
		    if(sNext.endsWith(":")) {
		    	iterator.remove();
		    }
		    if(sNext.contains("|")) {
		    	 sNext = sNext.substring(0 , sNext.indexOf("|"));
		    }
		}
		return guardList;
	}
	
	public static List<String> getSeniorGuards(String filePath) {
		File file = new File(filePath);
		List<String> guardList = new ArrayList<String>();
		try {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(file).useDelimiter(",\\s*");
			String token;
			List<String> temp = new ArrayList<String>();
			while(s.hasNextLine()) {
				token = s.nextLine().trim();
				if (token.contains("SENIOR GUARDS:")) {
					while(s.hasNextLine()) {
						if (token.contains("POOL SENIOR GUARDS:")) {
							break;
						}
						token = s.nextLine().trim();
						temp.add(token);
					}
				}
					
			}
			guardList = temp;
		} catch(Exception e){
			System.out.println("Error getting file!");
		}
		for (Iterator<String> iterator = guardList.iterator(); iterator.hasNext();) {
		    String sNext = iterator.next();
		    if(sNext == "") {
		        iterator.remove();
		    }
		    if(sNext.endsWith(":")) {
		    	iterator.remove();
		    }
		    if(sNext.contains("|")) {
		    	 sNext = sNext.substring(0 , sNext.indexOf("|"));
		    }
		}
		return guardList;
	}
	
	public static List<String> getGate(String filePath) {
		File file = new File(filePath);
		List<String> gate = new ArrayList<String>();
		try {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(file).useDelimiter(",\\s*");
			String token;
			List<String> temp = new ArrayList<String>();
			while(s.hasNextLine()) {
				token = s.nextLine().trim();
				if (token.contains("GATE")) {
					while(s.hasNextLine()) {
						if (token.contains("GROUNDS")) {
							break;
						}
						token = s.nextLine().trim();
						temp.add(token);
					}
				}
					
			}
			gate = temp;
		} catch(Exception e){
			System.out.println("Error getting file!");
		}
		for (Iterator<String> iterator = gate.iterator(); iterator.hasNext();) {
		    String sNext = iterator.next();
		    if(sNext == "") {
		        iterator.remove();
		    }
		    if(sNext.endsWith(":")) {
		    	iterator.remove();
		    }
		    if(sNext.contains("|")) {
		    	 sNext = sNext.substring(0 , sNext.indexOf("|"));
		    }
		}
		return gate;
	}
	
	public static List<String> getGround(String filePath) {
		File file = new File(filePath);
		List<String> ground = new ArrayList<String>();
		try {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(file).useDelimiter(",\\s*");
			String token;
			List<String> temp = new ArrayList<String>();
			while(s.hasNextLine()) {
				token = s.nextLine().trim();
				if (token.contains("GROUNDS")) {
					while(s.hasNextLine()) {
						token = s.nextLine().trim();
						temp.add(token);
					}
				}
					
			}
			ground = temp;
		} catch(Exception e){
			System.out.println("Error getting file!");
		}
		for (Iterator<String> iterator = ground.iterator(); iterator.hasNext();) {
		    String sNext = iterator.next();
		    if(sNext == "") {
		        iterator.remove();
		    }
		    if(sNext.endsWith(":")) {
		    	iterator.remove();
		    }
		    if(sNext.contains("|")) {
		    	 sNext = sNext.substring(0 , sNext.indexOf("|"));
		    }
		}
		//System.out.println("Size is " + ground.size());
		return ground;
	}

	public static List<String> getPoolSG(String filePath) {
		File file = new File(filePath);
		List<String> poolSG = new ArrayList<String>();
		try {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(file).useDelimiter(",\\s*");
			String token;
			List<String> temp = new ArrayList<String>();
			while(s.hasNextLine()) {
				token = s.nextLine().trim();
				if (token.contains("POOL SENIOR GUARDS:")) {
					while(s.hasNextLine()) {
						if (token.contains("GATE")) {
							break;
						}
						token = s.nextLine().trim();
						temp.add(token);
					}
				}
					
			}
			poolSG = temp;
		} catch(Exception e){
			System.out.println("Error getting file!");
		}
		for (Iterator<String> iterator = poolSG.iterator(); iterator.hasNext();) {
		    String sNext = iterator.next();
		    if(sNext == "") {
		        iterator.remove();
		    }
		    if(sNext.endsWith(":")) {
		    	iterator.remove();
		    }
		    if(sNext.contains("|")) {
		    	 sNext = sNext.substring(0 , sNext.indexOf("|"));
		    }
		}
		//System.out.println("Size is " + ground.size());
		return poolSG;
	}
	
	
}

