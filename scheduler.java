package lifeguardScheduler;

import java.util.List;
import java.util.ArrayList;

public class scheduler {
	List<lifeguard> lifeguardList;
	manager manager;
	final static int numberOfLifegaurds = 4;
	final static int numberOfSeniorGuards = 1;
	headGuard headGuard;
	asstManager asstManager;
	gate[] gate;
	boolean gateOn;
	boolean seniorGuardOn;
	days[] daysOfWeek;
	
	public scheduler() {
		new ArrayList<String>();
		this.asstManager = new asstManager("Alexis");
		this.gate = new gate[]{new gate("Gate1"), new gate("Gate2")};
		this.headGuard = new headGuard("Cameron");
		this.lifeguardList = new ArrayList<lifeguard>();
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
	
	public void generateSchedule(){
		
		for(lifeguard l : this.lifeguardList) {
			l.checkAvailability();
			System.out.println(l.name + " is not available on these days: " + l.daysNotAvailable);
		}
		
			for (days d : this.daysOfWeek) {
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
		//schedule.lifeguardList.add(new lifeguard("seven"));
		//schedule.lifeguardList.add(new lifeguard("eight"));
		//schedule.lifeguardList.add(new lifeguard("nine"));
		schedule.generateSchedule();
		}

	}


