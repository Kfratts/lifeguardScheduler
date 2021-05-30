package lifeguardScheduler;

import java.util.List;
import java.util.ArrayList;

public class scheduler {
	List<lifeguard> lifeguards;
	manager manager;
	final static int numberOfLifegaurds = 5;
	final static int numberOfSeniorGuards = 1;
	headGuard headGuard;
	asstManager asstManager;
	gate[] gate;
	int numGuards;
	boolean gateOn;
	boolean seniorGuardOn;
	days[] daysOfWeek;
	
	public scheduler() {
		new ArrayList<String>();
		this.asstManager = new asstManager("Alexis");
		this.gate = new gate[]{new gate("Gate1"), new gate("Gate2")};
		this.headGuard = new headGuard("Cameron");
		this.lifeguards = new ArrayList<lifeguard>();
		this.manager = new manager("Luke");
		this.daysOfWeek = new days[]{new days("Monday"), new days("Tuesday"), new days("Wednesday"), new days("Thursday"), new days("Friday"), new days("Saturday"), new days("Sunday")};
	}
	
	public void addGuards(lifeguard guard) {
		lifeguards.add(guard);
	}
	
	public void generateSchedule(){
		for(lifeguard l : this.lifeguards) {
			l.checkAvailability();
		}
		for(lifeguard l : this.lifeguards) {
			System.out.println(l.name + " is not available on these days: " + l.daysNotAvailable);
		}
		for (days d : daysOfWeek) {
			int numberGuards = 0;
			while(numberGuards != 5) {
				for(lifeguard l : this.lifeguards) {
					if(l.numDays == 5) {
						lifeguards.remove(l);
					}
					if(l.numDays < 3) {
						d.guardsOnDay.add(l);
						l.numDays++;
						numberGuards++;
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
		schedule.addGuards(new lifeguard("one"));
		schedule.addGuards(new lifeguard("two"));
		schedule.addGuards(new lifeguard("three"));
		schedule.addGuards(new lifeguard("four"));
		schedule.addGuards(new lifeguard("five"));
		schedule.addGuards(new lifeguard("six"));
		schedule.addGuards(new lifeguard("seven"));
		schedule.addGuards(new lifeguard("eight"));
		schedule.addGuards(new lifeguard("nine"));
		schedule.generateSchedule();
		}

	}


