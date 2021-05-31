package lifeguardScheduler;

import java.util.List;
import java.util.ArrayList;

public class scheduler {
	List<lifeguard> lifeguardList;
	List<seniorGuard> seniorGuards;
	manager manager;
	headGuard headGuard;
	asstManager asstManager;
	gate[] gate;
	days[] daysOfWeek;
	
	public scheduler() {
		new ArrayList<String>();
		this.asstManager = new asstManager("Alexis");
		this.gate = new gate[]{new gate("Gate1"), new gate("Gate2")};
		this.headGuard = new headGuard("Cameron");
		this.lifeguardList = new ArrayList<lifeguard>();
		this.seniorGuards = new ArrayList<seniorGuard>();
		this.manager = new manager("Luke");
		this.daysOfWeek = new days[]{new days("Monday"), new days("Tuesday"), new days("Wednesday"), new days("Thursday"), new days("Friday"), new days("Saturday"), new days("Sunday")};
	}
	
	public void addGuards(lifeguard guard) {
		lifeguardList.add(guard);
	}
	
	public static lifeguard nextElement(List<lifeguard> list,lifeguard element){
		int index = list.indexOf(element)+1;
		if(index == list.size()) {
			lifeguard guardNext = list.get(0);
			return guardNext;
		}
	    lifeguard guardNext = list.get(index);
	    return guardNext;

	}
	
	public static seniorGuard nextElementSG(List<seniorGuard> list,seniorGuard element){
		int index = list.indexOf(element)+1;
		if(index == list.size()) {
			seniorGuard guardNext = list.get(0);
			return guardNext;
		}
	    seniorGuard guardNext = list.get(index);
	    return guardNext;

	}
	
	public void generateSchedule(){
		
		for(lifeguard l : this.lifeguardList) {
			l.checkAvailability();
			System.out.println(l.name + " is not available on these days: " + l.daysNotAvailable);
		}
		for(seniorGuard sg : this.seniorGuards) {
			sg.SGcheckAvailability();
			System.out.println(sg.name + " is not available on these days: " + sg.daysNotAvailable);
		}
		
			for (days d : this.daysOfWeek) {
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
			}
		}
		
		
	
	
	public static void main(String[] args) {
		scheduler schedule = new scheduler();
		schedule.lifeguardList.add(new lifeguard("one"));
		schedule.lifeguardList.add(new lifeguard("two"));
		schedule.lifeguardList.add(new lifeguard("three"));
		schedule.lifeguardList.add(new lifeguard("four"));
		schedule.lifeguardList.add(new lifeguard("five"));
		schedule.lifeguardList.add(new lifeguard("six"));
		schedule.seniorGuards.add(new seniorGuard("SG ONE"));
		schedule.seniorGuards.add(new seniorGuard("SG TWO"));
		schedule.seniorGuards.add(new seniorGuard("SG THREE"));
		//schedule.lifeguardList.add(new lifeguard("seven"));
		//schedule.lifeguardList.add(new lifeguard("eight"));
		//schedule.lifeguardList.add(new lifeguard("nine"));
		schedule.generateSchedule();
		}

	}


