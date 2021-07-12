package lifeguardScheduler;

import java.io.FileNotFoundException;
import java.util.*; 

public class scheduler {
	
	public static void main(String[] args) {
		int start, end; 

		Scanner s = new Scanner(System.in); 
		
		schedule schedule = new schedule();
		
		//Sets up the start and end date the schedule will be made from
		System.out.println("What dates would you like to make the schedule from? "
				+ "\n Please enter the month of the starting date (Example: June");
		String startMonth = s.nextLine();
		
		System.out.println("Please enter the day (Exmaple: 21");
		
		start = s.nextInt();
		
		System.out.println("Please enter the day for the end period");
		
		end = s.nextInt(); 
		for(gateGuard g : schedule.gateGuards) {
			System.out.println("IN LOOP");
			System.out.println(g.name);
		}
		for(day d : schedule.daysInPeriod) {
			System.out.println(d.name);
		}
		
		employeeFile.createFileAndInitialize();
		schedule.createEmployeeLists();
		//schedule.generateSchedule(start, end);
		try {
			schedule.checkAvailability("C:\\Users\\18452\\cs140\\eclipse\\src\\Lifeguard_Scheduler\\src\\lifeguardScheduler\\employee.text");
		} catch (FileNotFoundException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		schedule.generateSchedule(start, end, startMonth);
		schedule.generatePoolSchedule();
		System.out.println(schedule.daysInPeriod);
		for(day d : schedule.daysInPeriod) {
			System.out.println(d.name);
			System.out.println("---------------------");
			System.out.println("LIFEGUARDS:");
			for (lifeguard l : d.guardsOnDay) {
				System.out.println(l.name);
			}
			System.out.println("SENIOR GUARDS:");
			for (seniorGuard sg : d.sgOnDay) {
				System.out.println(sg.name);
			}
			System.out.println("GATE:");
			for (gateGuard g : d.gateOnDay) {
				System.out.println(g.name);
			}
			System.out.println("---------------------");
			System.out.println("POOL:");
			for(lifeguard lg : d.guardsAtPool) {
				System.out.println(lg.name);
			}
			System.out.println("---------------------");
		}
		
		
		s.close();
		System.out.println("DONE");
	}
}

