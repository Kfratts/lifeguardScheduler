package lifeguardScheduler;

import java.util.List;
import java.util.ArrayList;

public class scheduler {
	List<lifeguard> lifeguardList;
	List<seniorGuard> seniorGuards;
	List<gate> gate;
	manager manager;
	headGuard headGuard;
	asstManager asstManager;
	days[] daysOfWeek;
	
	public scheduler() {
		new ArrayList<String>();
		this.asstManager = new asstManager("Alexis");
		this.gate = new ArrayList<gate>();
		this.headGuard = new headGuard("Cameron");
		this.lifeguardList = new ArrayList<lifeguard>();
		this.seniorGuards = new ArrayList<seniorGuard>();
		this.manager = new manager("Luke");
		this.daysOfWeek = new days[]{new days("Monday"), new days("Tuesday"), new days("Wednesday"), new days("Thursday"), new days("Friday"), new days("Saturday"), new days("Sunday")};
	}
	
	//public void addGuards(lifeguard guard) {
		//lifeguardList.add(guard);
	//}
	/*
	 * Returns the next element in the lifeguard list. 
	 * @param list: lifeguards list
	 * @param element: element in list that will be used as the index for next element
	 * @return guardNext: returns next element in the list
	 */
	public static lifeguard nextElement(List<lifeguard> list,lifeguard element){
		int index = list.indexOf(element)+1;
		if(index == list.size()) {
			lifeguard guardNext = list.get(0);
			return guardNext;
		}
	    lifeguard guardNext = list.get(index);
	    return guardNext;

	}
	/*
	 * Returns the next element in the senior guards list. 
	 * @param list: senior guards list
	 * @param element: element in list that will be used as the index for next element
	 * @return guardNext: returns next element in the list
	 */
	public static seniorGuard nextElementSG(List<seniorGuard> list,seniorGuard element){
		int index = list.indexOf(element)+1;
		if(index == list.size()) {
			seniorGuard guardNext = list.get(0);
			return guardNext;
		}
	    seniorGuard guardNext = list.get(index);
	    return guardNext;

	}
	/*
	 * Returns the next element in the gate list. 
	 * @param list: gate list
	 * @param element: element in list that will be used as the index for next element
	 * @return guardNext: returns next element in the list
	 */
	public static gate nextElementGate(List<gate> list, gate element){
		int index = list.indexOf(element)+1;
		if (index == list.size()) {
			gate next = list.get(0);
			return next;
		}
		gate next = list.get(index);
		return next;
		
	}
	/*
	 * Generates Schedule and ensures the correct number of lifeguards, senior guards, head guard, manager, asst manager, grounds personnel are on duty.
	 * @param None
	 * @return None
	 */
	public void generateSchedule(){
		//check availability of lifeguards, senior guards, and gate personell
		for(lifeguard l : this.lifeguardList) {
			l.checkAvailability();
			System.out.println(l.name + " is not available on these days: " + l.daysNotAvailable);
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
		schedule.gate.add(new gate("Gate ONE"));
		schedule.gate.add(new gate("Gate TWO"));
		//schedule.lifeguardList.add(new lifeguard("seven"));
		//schedule.lifeguardList.add(new lifeguard("eight"));
		//schedule.lifeguardList.add(new lifeguard("nine"));
		schedule.generateSchedule();
		}

	}


