package lifeguardScheduler;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class schedule {
	static List<lifeguard> lifeguards;
	static List<seniorGuard> seniorGuards;
	static List<gateGuard> gateGuards;
	private static List<grounds> grounds;
	static List<day> daysInPeriod;
	static List<lifeguard> lifeguardsAtPool;
	static List<poolSeniorGuard> poolSG;
	
	public schedule() {
		schedule.daysInPeriod = new ArrayList<day>();
		schedule.gateGuards = new ArrayList<gateGuard>();
		schedule.lifeguards = new ArrayList<lifeguard>();
		schedule.seniorGuards = new ArrayList<seniorGuard>();
		schedule.lifeguardsAtPool = new ArrayList<lifeguard>();
		schedule.poolSG = new ArrayList<poolSeniorGuard>();
	}

	public void checkAvailability(employeeFile file) throws FileNotFoundException {
		for(lifeguard l : schedule.lifeguards) {
			Scanner s;
			try {
				s = new Scanner(file.file).useDelimiter(",\\s*");
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
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(seniorGuard sg : schedule.seniorGuards) {
			Scanner s = new Scanner(file.file).useDelimiter(",\\s*");
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
			Scanner s = new Scanner(file.file).useDelimiter(",\\s*");
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
			Scanner s = new Scanner(file.file).useDelimiter(",\\s*");
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
		for(poolSeniorGuard psg : schedule.poolSG) {
			Scanner s = new Scanner(file.file).useDelimiter(",\\s*");
			while(s.hasNextLine()) {
				String token = s.nextLine();
				if(token.contains(psg.getName())){
					String days = token.substring(token.indexOf("|") + 1);
					days.replaceAll("\\s","");
					List<String> tempDays = Arrays.asList(days.split("\\s*,\\s*"));
					List<day> dayList = new ArrayList<day>();
					for(String day : tempDays) {
						String tempDay = day.replaceAll("\\s","");
						dayList.add(new day(Integer.parseInt(tempDay)));
					}
					psg.daysNotAvailable = dayList;
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
			for (day d : schedule.daysInPeriod) {
				if(d.name == num) {
					for (lifeguard lg : d.guardsOnDay) {
						if(lg.name.contains(l.name)) {
							check = true;
						}
					}
					for(poolSeniorGuard lgp : d.poolSGOnDay) {
						if(lgp.name.contains(l.name)) {
							check = true;
						}
					}
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
		lifeguard l = lifeguards.get(index);
		l.numDays++;
		l.daysNotAvailable.add(new day(num));
		
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
		
		/*
		 * ran into error when there were no senior guards on a day, the method would just return the senior guard that was index zero in 
		 * the senior guards list. Now the method returns "NONE" when no senior guard is available.
		 */
		
		for (day d : seniorGuards.get(index).daysNotAvailable) {
			if(d.name == num) return new seniorGuard("NONE");
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
		
		for (day d : gateGuards.get(index).daysNotAvailable) {
			if(d.name == num) return new gateGuard("NONE");
		}

		gateGuards.get(index).numDays++;
		
		return gateGuards.get(index);
	}
	
	public static grounds getGrounds(int num) {
		int min = 10;
		int indexTemp = 0;
		int index = 0;
		boolean check = false;
		
		for(grounds g : grounds) {
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
		
		for (day d : grounds.get(index).daysNotAvailable) {
			if(d.name == num) return new grounds("NONE");
		}

		grounds.get(index).numDays++;
		
		return grounds.get(index);
	}
	
	public static poolSeniorGuard getPoolSG(int num) {
		int min = 10;
		int indexTemp = 0;
		int index = 0;
		boolean check = false;
		
		for(poolSeniorGuard psg : poolSG) {
			for(day d : psg.daysNotAvailable) {
				if(d.name== num) {
					check = true;
				}
			}
		
		for (day d : schedule.daysInPeriod) {
			if(d.name == num) {
				for (lifeguard l : d.guardsOnDay) {
					if(l.name.contains(psg.name)) {
						check = true;
					}
				}
				for(seniorGuard sg : d.sgOnDay) {
					if(sg.name.contains(psg.name)) {
						check = true;
					}
				}
			}
		}
		
		Integer numDaysTemp = psg.numDays;
		if(numDaysTemp < min && check == false) {
			min = numDaysTemp;
			index = indexTemp;
		}
		indexTemp++;
		check = false;
		}
		
		for (day d : poolSG.get(index).daysNotAvailable) {
			if(d.name == num) return new poolSeniorGuard("NONE");
		}

		poolSG.get(index).numDays++;
		
		return poolSG.get(index);
	}
	
	/*
	 * Generates Schedule and ensures the correct number of lifeguards, senior guards, head guard, manager, asst manager, grounds personnel are on duty.
	 * @param None
	 * @return None
	 */
	
	@SuppressWarnings("unlikely-arg-type")
	public void generateSchedule(int beg, int end, String startMonth) {
		int numDaysInStart;
		if (startMonth.toUpperCase().contains("MAY")) {
			numDaysInStart = 31;
		}
		if (startMonth.toUpperCase().contains("JUNE")) {
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
		
		if(beg > end) {
			for(int i = beg; i <= numDaysInStart + 1; i++) {
				day dayOfWeek = new day(i);
				daysInPeriod.add(dayOfWeek);
			}
			for(int i = 1; i < end + 1; i++) {
				day dayOfWeek = new day(i);
				daysInPeriod.add(dayOfWeek);
			}
		}
		else {
			for(int i = beg; i <= end; i ++) {
				day dayofWeek = new day(i);
				daysInPeriod.add(dayofWeek);
			}
		}
		

		for(day d : schedule.daysInPeriod) {
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
			for (grounds g : schedule.grounds) {
				if(d.numGrounds < 1) {
					if(g.numDays < 10) {
						if(!(g.daysNotAvailable.contains(d.name))) {
							if(!(d.groundsOnDay.contains(g)) && d.numGrounds < 1) {
								if(d.numGrounds < 1) {
									d.groundsOnDay.add(schedule.getGrounds(d.name));
									
									d.numGrounds++;
								}
								else {
									if(d.numGrounds < 1) {
										//System.out.println(d.numGuards);
										d.groundsOnDay.add(schedule.getGrounds(d.name));
										//System.out.println(l.name);
										
										d.numGrounds++;
									}
								}
							}
						}
					}
				}
			
			}
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void generatePoolSchedule() {
		for (day d : daysInPeriod) {
			for (poolSeniorGuard psg : schedule.poolSG) {
				if(d.numPoolSG < 1) {
					if(psg.numDays < 10) {
						if(!(psg.daysNotAvailable.contains(d.name))) {
							if(!(d.poolSGOnDay.contains(psg)) && d.numGuardsPool < 1) {
								if(d.numPoolSG < 1) {
									d.poolSGOnDay.add(schedule.getPoolSG(d.name));
									
									d.numPoolSG++;
								}
								else {
									if(d.numPoolSG < 1) {
										//System.out.println(d.numGuards);
										d.poolSGOnDay.add(schedule.getPoolSG(d.name));
										//System.out.println(l.name);
										
										d.numPoolSG++;
									}
								}
							}
						}
					}
				}
			
			}
			for (lifeguard l : schedule.lifeguards) {
				if(d.numGuardsPool < 3) {
					if(l.numDays < 10) {
						if(!(l.daysNotAvailable.contains(d.name))) {
							if(!(d.guardsAtPool.contains(l)) && d.numGuardsPool < 3) {
								if(d.numGuardsPool < 3) {
									d.guardsAtPool.add(schedule.getGuard(d.name));
									
									d.numGuardsPool++;
								}
								else {
									if(d.numGuardsPool < 3) {
										//System.out.println(d.numGuards);
										d.guardsAtPool.add(schedule.getGuard(d.name));
										//System.out.println(l.name);
										
										d.numGuardsPool++;
									}
								}
							}
						}
					}
				}
			
			}
		}
	}
	
	public void createEmployeeLists(employeeFile file) {
		//creating lifeguard Array

		List<String> lifeguardList = new ArrayList<String>();
		lifeguardList = file.getLifeguards();
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
		SGList = file.getSeniorGuards();
		
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
		gate = file.getGate();
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
		grounds = file.getGround();
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
		
		List<String> poolSGTemp = new ArrayList<String>();
		poolSGTemp = file.getPoolSG();
		List<poolSeniorGuard> poolSGList = new ArrayList<poolSeniorGuard>();
		for(String g : poolSGTemp) {
			try {
			g = g.substring(0, g.indexOf("|"));
			}catch(Exception e) {
				poolSGList.add(new poolSeniorGuard(g));
			}
			poolSGList.add(new poolSeniorGuard(g));
		}
		schedule.poolSG = poolSGList;
		
	}
	
	//getter methods
	
	public lifeguard getLifeguard(int index) {
		return lifeguards.get(index); 
	}
	
	public int getLifeguardsSize() {
		return lifeguards.size(); 
	}
	
}
