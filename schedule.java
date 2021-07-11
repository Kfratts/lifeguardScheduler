package lifeguardScheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class schedule {
	static List<lifeguard> lifeguards;
	static List<seniorGuard> seniorGuards;
	static List<gateGuard> gateGuards;
	private static List<grounds> grounds;
	private manager manager;
	private headGuard headGuard;
	private	asstManager asstManager;
	List<day> daysInPeriod;
	
	public schedule() {
		this.daysInPeriod = new ArrayList<day>();
		this.asstManager = new asstManager("Alexis");
		schedule.gateGuards = new ArrayList<gateGuard>();
		this.headGuard = new headGuard("Cameron");
		schedule.lifeguards = new ArrayList<lifeguard>();
		schedule.seniorGuards = new ArrayList<seniorGuard>();
		this.manager = new manager("Luke");
	}

	/*
	 * Generates Schedule and ensures the correct number of lifeguards, senior guards, head guard, manager, asst manager, grounds personnel are on duty.
	 * @param None
	 * @return None
	 */
	/*public void generateSchedule(){
		//check availability of lifeguards, senior guards, and gate personell
		for(lifeguard l : this.lifeguards) {
			l.checkAvailability();
			System.out.println(l.getName() + " is not available on these days: " + l.getDaysNotAvailable());
		}
		for(seniorGuard sg : this.seniorGuards) {
			sg.SGcheckAvailability();
			System.out.println(sg.name + " is not available on these days: " + sg.daysNotAvailable);
		}
		for(gate g : this.gate) {
			g.checkAvailability();
			System.out.println(g.name + " is not available on these days: " + g.daysNotAvailable);
		}
		
		
			for (days d : this.daysOfWeek) { //iterate days of week array
					for(gate g : this.gate) { //iterate gate personell
						if(d.numGate < 1) {  //minimum number of gate personell per day is 1
							if(g.numDays < 4) { //ensure no gate personell works more than 4 days
								if (!(g.daysNotAvailable.contains(d.name))) { //ensure the gate personell is available at current day
									if(!(d.gateOnDay.contains(g)) && d.numGate < 1) { //ensure the gate personell was not already added
										if(nextElementGate(this.gate, g).numDays < g.numDays && d.numGate < 1) { //check to make sure one gate personell isn't working more than another
											d.gateOnDay.add(nextElementGate(this.gate, g)); //add next gate personell to schedule if they have less days working than the previous gate personell.
											nextElementGate(this.gate, g).numDays++; //add one to the number of days worked by that gate personell
											d.numGate++; //add one to the number of gate personell
										}
										else {
											if(d.numSG < 2) {
												//System.out.println(d.numGuards);
												d.gateOnDay.add(g);
												//System.out.println(l.name);
												g.numDays++;
												d.numGate++;
											}
										}
									}
								}
							}
						}
					}
					for(seniorGuard sg : seniorGuards) {
						if(d.numSG < 2) {
							if(sg.numDays < 5) {
								if(!(sg.daysNotAvailable.contains(d.name))) {
									if(!(d.sgOnDay.contains(sg)) && d.numGuards < 2) {
										if(nextElementSG(seniorGuards, sg).numDays < sg.numDays && d.numSG < 2) {
											d.sgOnDay.add(nextElementSG(seniorGuards, sg));
											nextElementSG(seniorGuards, sg).numDays++;
											d.numSG++;
										}
										else {
											if(d.numSG < 2) {
												//System.out.println(d.numGuards);
												d.sgOnDay.add(sg);
												//System.out.println(l.name);
												sg.numDays++;
												d.numSG++;
											}
										}
									}
								}
							}
						}
					}
				for (lifeguard l : lifeguardList) {
					if(d.numGuards < 4) {
						if(l.numDays < 5) {
							if(!(l.daysNotAvailable.contains(d.name))) {
								if(!(d.guardsOnDay.contains(l)) && d.numGuards < 4) {
									if(nextElement(lifeguardList, l).numDays < l.numDays && d.numGuards < 4) {
										d.guardsOnDay.add(nextElement(lifeguardList, l));
										nextElement(lifeguardList, l).numDays++;
										d.numGuards++;
									}
									else {
										if(d.numGuards < 4) {
											//System.out.println(d.numGuards);
											d.guardsOnDay.add(l);
											//System.out.println(l.name);
											l.numDays++;
											d.numGuards++;
										}
									}
								}
							}
						}
					}
				
				}
				System.out.println("Day of Week: " + d.name);
				for(lifeguard guard : d.guardsOnDay) {
					System.out.println("Guards on: " + guard.name);
				}
				for(seniorGuard senior : d.sgOnDay) {
					System.out.println("Senior Guards On: " + senior.name);
				}
				for(gate gate : d.gateOnDay) {
					System.out.println("Gate On: " + gate.name);
				}
			}
		}
		* 
	*/
	
	public void checkAvailability(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		for(lifeguard l : schedule.lifeguards) {
			Scanner s = new Scanner(file).useDelimiter(",\\s*");
			while(s.hasNextLine()) {
				String token = s.nextLine();
				if(token.contains(l.getName())) {
					String days = token.substring(token.indexOf("|") + 1);
					days.replaceAll("\\s","");
					List<String> tempDays = Arrays.asList(days.split("\\s*,\\s*"));
					List<day> dayList = new ArrayList<day>();
					for(String day : tempDays) {
						String tempDay = day.replaceAll("\\s","");
						dayList.add(new day(Integer.parseInt(tempDay)));
					}
					l.daysNotAvailable = dayList;
					dayList = null;
				}
			}
			s.close();
		}
		for(seniorGuard sg : schedule.seniorGuards) {
			Scanner s = new Scanner(file).useDelimiter(",\\s*");
			while(s.hasNextLine()) {
				String token = s.nextLine();
				if(token.contains(sg.getName())){
					String days = token.substring(token.indexOf("|") + 1);
					days.replaceAll("\\s","");
					List<String> tempDays = Arrays.asList(days.split("\\s*,\\s*"));
					List<day> dayList = new ArrayList<day>();
					for(String day : tempDays) {
						String tempDay = day.replaceAll("\\s","");
						dayList.add(new day(Integer.parseInt(tempDay)));
					}
					sg.daysNotAvailable = dayList;
					dayList = null;
				}
			}
			s.close();
		}
		for(gateGuard g : schedule.gateGuards) {
			Scanner s = new Scanner(file).useDelimiter(",\\s*");
			while(s.hasNextLine()) {
				String token = s.nextLine();
				if(token.contains(g.getName())){
					String days = token.substring(token.indexOf("|") + 1);
					days.replaceAll("\\s","");
					List<String> tempDays = Arrays.asList(days.split("\\s*,\\s*"));
					List<day> dayList = new ArrayList<day>();
					for(String day : tempDays) {
						String tempDay = day.replaceAll("\\s","");
						dayList.add(new day(Integer.parseInt(tempDay)));
					}
					g.daysNotAvailable = dayList;
					dayList = null;
				}
			}
			s.close();
		}
		for(grounds g : schedule.grounds) {
			Scanner s = new Scanner(file).useDelimiter(",\\s*");
			while(s.hasNextLine()) {
				String token = s.nextLine();
				if(token.contains(g.getName())){
					String days = token.substring(token.indexOf("|") + 1);
					days.replaceAll("\\s","");
					List<String> tempDays = Arrays.asList(days.split("\\s*,\\s*"));
					List<day> dayList = new ArrayList<day>();
					for(String day : tempDays) {
						String tempDay = day.replaceAll("\\s","");
						dayList.add(new day(Integer.parseInt(tempDay)));
					}
					g.daysNotAvailable = dayList;
					dayList = null;
				}
			}
			s.close();
		}
	}
	
	public static lifeguard getGuard(int num) {
		int min = 10;
		int indexTemp = 0;
		int index = 0;
		boolean check = false;
		
		for(lifeguard l : lifeguards) {
			for(day d : l.daysNotAvailable) {
				if(d.name== num) {
					check = true;
				}
			}
			Integer numDaysTemp = l.numDays;
			if(numDaysTemp < min && check == false) {
				min = numDaysTemp;
				index = indexTemp;
			}
			indexTemp++;
			check = false;
		}
		lifeguards.get(index).numDays++;
		return lifeguards.get(index);
	}
	public static seniorGuard getSeniorGuard(int num) {
		int min = 10;
		int indexTemp = 0;
		int index = 0;
		boolean check = false;
		
		for(seniorGuard sg : seniorGuards) {
			for(day d : sg.daysNotAvailable) {
				if(d.name== num) {
					check = true;
				}
			}
			Integer numDaysTemp = sg.numDays;
			if(numDaysTemp < min && check == false) {
				min = numDaysTemp;
				index = indexTemp;
			}
			indexTemp++;
			check = false;
		}
		seniorGuards.get(index).numDays++;
		return seniorGuards.get(index);
	}
	
	public static gateGuard getGateGuard(int num) {
		int min = 10;
		int indexTemp = 0;
		int index = 0;
		boolean check = false;
		
		for(gateGuard g : gateGuards) {
			for(day d : g.daysNotAvailable) {
				if(d.name== num) {
					check = true;
				}
			}
			Integer numDaysTemp = g.numDays;
			if(numDaysTemp < min && check == false) {
				min = numDaysTemp;
				index = indexTemp;
			}
			indexTemp++;
			check = false;
		}
		gateGuards.get(index).numDays++;
		return gateGuards.get(index);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void generateSchedule(int beg, int end, String startMonth) {
		int numDaysInStart;
		if (startMonth.toUpperCase().contains("MAY")) {
			numDaysInStart = 31;
		}
		if (startMonth.toUpperCase().contains("JUNE")) {
			System.out.println("YUP");
			numDaysInStart = 30;
		}
		if (startMonth.toUpperCase().contains("JULY")) {
			numDaysInStart = 31;
		}
		if (startMonth.toUpperCase().contains("AUGUST")) {
			numDaysInStart = 31;
		}
		else{
			numDaysInStart = 30;
		}
		
		int numDaysInBegMonth = numDaysInStart - beg;
		System.out.println(numDaysInBegMonth);
		int numDaysInEndMonth = end - numDaysInBegMonth;
		if(beg > end) {
			ArrayList<day> days = new ArrayList<day>();
			for(int i = beg; i < numDaysInStart; i++) {
				day dayOfWeek = new day(i);
				daysInPeriod.add(dayOfWeek);
			}
			for(int i = 1; i < end + 1; i++) {
				day dayOfWeek = new day(i);
				daysInPeriod.add(dayOfWeek);
			}
		}
		else {
			for(int i = beg; i <= end - beg + 1; i ++) {
				day dayofWeek = new day(i);
				daysInPeriod.add(dayofWeek);
			}
		}
		

		for(day d : this.daysInPeriod) {
			for (lifeguard l : schedule.lifeguards) {
				if(d.numGuards < 4) {
					if(l.numDays < 10) {
						if(!(l.daysNotAvailable.contains(d.name))) {
							if(!(d.guardsOnDay.contains(l)) && d.numGuards < 4) {
								if(d.numGuards < 4) {
									d.guardsOnDay.add(schedule.getGuard(d.name));
									
									d.numGuards++;
								}
								else {
									if(d.numGuards < 4) {
										//System.out.println(d.numGuards);
										d.guardsOnDay.add(schedule.getGuard(d.name));
										//System.out.println(l.name);
										
										d.numGuards++;
									}
								}
							}
						}
					}
				}
			
			}
			for (seniorGuard sg : schedule.seniorGuards) {
				if(d.numSG < 4) {
					if(sg.numDays < 10) {
						if(!(sg.daysNotAvailable.contains(d.name))) {
							if(!(d.sgOnDay.contains(sg)) && d.numSG < 1) {
								if(d.numSG < 1) {
									d.sgOnDay.add(schedule.getSeniorGuard(d.name));
									
									d.numSG++;
								}
								else {
									if(d.numSG < 1) {
										//System.out.println(d.numGuards);
										d.sgOnDay.add(schedule.getSeniorGuard(d.name));
										//System.out.println(l.name);
										
										d.numGuards++;
									}
								}
							}
						}
					}
				}
			
			}
			for (gateGuard g : schedule.gateGuards) {
				if(d.numGate < 1) {
					if(g.numDays < 10) {
						if(!(g.daysNotAvailable.contains(d.name))) {
							if(!(d.gateOnDay.contains(g)) && d.numGate < 1) {
								if(d.numGate < 1) {
									d.gateOnDay.add(schedule.getGateGuard(d.name));
									
									d.numGate++;
								}
								else {
									if(d.numGate < 1) {
										//System.out.println(d.numGuards);
										d.gateOnDay.add(schedule.getGateGuard(d.name));
										//System.out.println(l.name);
										
										d.numGate++;
									}
								}
							}
						}
					}
				}
			
			}
		}
	}
	
	public void createEmployeeLists() {
		//creating lifeguard Array
		List<String> lifeguardList = new ArrayList<String>();
		lifeguardList = employeeFile.getLifeguards("C:\\Users\\18452\\cs140\\eclipse\\src\\Lifeguard_Scheduler\\src\\lifeguardScheduler\\employee.text");
		List<lifeguard> guardList = new ArrayList<lifeguard>();
		for(String guard : lifeguardList) {
			try {
			guard = guard.substring(0, guard.indexOf("|"));
			}catch(Exception e) {
			guardList.add(new lifeguard(guard));
			}
			guardList.add(new lifeguard(guard));
		}
		
		schedule.lifeguards = guardList;
		
		
		
		List<String> SGList = new ArrayList<String>();
		SGList = employeeFile.getSeniorGuards("C:\\Users\\18452\\cs140\\eclipse\\src\\Lifeguard_Scheduler\\src\\lifeguardScheduler\\employee.text");
		
		List<seniorGuard> sgList = new ArrayList<seniorGuard>();
		for (String sg : SGList) {
			try {
				sg = sg.substring(0, sg.indexOf("|"));
			}catch(Exception e) {
				sgList.add(new seniorGuard(sg));
			}
			
			sgList.add(new seniorGuard(sg));
		}
		schedule.seniorGuards = sgList;
		
		List<String> gate = new ArrayList<String>();
		gate = employeeFile.getGate("C:\\Users\\18452\\cs140\\eclipse\\src\\Lifeguard_Scheduler\\src\\lifeguardScheduler\\employee.text");
		List<gateGuard> gateList = new ArrayList<gateGuard>();
		for(String g : gate) {
			try {
			g = g.substring(0, g.indexOf("|"));
			}catch(Exception e) {
				gateList.add(new gateGuard(g));
			}
			gateList.add(new gateGuard(g));
		}
		schedule.gateGuards = gateList;
 
		List<String> grounds = new ArrayList<String>();
		grounds = employeeFile.getGround("C:\\Users\\18452\\cs140\\eclipse\\src\\Lifeguard_Scheduler\\src\\lifeguardScheduler\\employee.text");
		List<grounds> groundsList = new ArrayList<grounds>();
		for(String g : grounds) {
			try {
				g = g.substring(0, g.indexOf("|"));
			} catch(Exception e){
				groundsList.add(new grounds(g));
			}
			groundsList.add(new grounds(g));
		}
		schedule.grounds = groundsList;
		
	}
	
	
	
	
	//getter methods
	
	public lifeguard getLifeguard(int index) {
		return lifeguards.get(index); 
	}
	
	public int getLifeguardsSize() {
		return lifeguards.size(); 
	}
	
}
