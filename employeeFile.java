package lifeguardScheduler;

import java.util.*; 

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.awt.Desktop;  

public class employeeFile {
	File file;
	
	public employeeFile(String name) {
		this.file = createFileAndInitialize(name);
	}
	
	public static File createFileAndInitialize(String name){
		
			File file = new File(name);
			if(file.exists()) {
				System.out.println("File already exists, would you like to edit this file?");
				System.out.println("If so, type 'yes', if not then type 'no'");
				@SuppressWarnings("resource")
				Scanner s = new Scanner(System.in); 
				String answer = s.nextLine(); 
				if(answer.toUpperCase().equals("YES")) {
					employeeFile.editFile(file);
				}
			}
			else {
				Scanner s = new Scanner(System.in); 
				//create file
				try {
					file.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Created an employee file to track employees");
				//create file writer
				FileWriter writer;
				try {
					writer = new FileWriter(file);
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
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return file;
	}
	
	public static void editFile(File file) {
		try {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(file);
		}catch(Exception e){
			System.out.println("This action is not supported!");
		}
	}
	public List<String> getLifeguards() {
		List<String> guardList = new ArrayList<String>();
		try {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(this.file).useDelimiter(",\\s*");
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
	
	public List<String> getSeniorGuards() {
		List<String> guardList = new ArrayList<String>();
		try {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(this.file).useDelimiter(",\\s*");
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
	
	public List<String> getGate() {
		List<String> gate = new ArrayList<String>();
		try {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(this.file).useDelimiter(",\\s*");
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
	
	public List<String> getGround() {
		List<String> ground = new ArrayList<String>();
		try {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(this.file).useDelimiter(",\\s*");
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

	public List<String> getPoolSG() {
		List<String> poolSG = new ArrayList<String>();
		try {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(this.file).useDelimiter(",\\s*");
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

