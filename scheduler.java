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
				+ "\nDo not go past the last day of the month for the range(i.e do not input 28 to the 5)"
				+ "\nEnter the start date then press enter: ");
		start = s.nextInt();
		
		System.out.println("Enter the end date then press enter: "); 
		end = s.nextInt(); 
		employeeFile.createFileAndInitialize();
		schedule.createEmployeeLists();
		//schedule.generateSchedule(start, end);
		try {
			schedule.checkAvailability("C:\\Users\\18452\\cs140\\eclipse\\src\\Lifeguard_Scheduler\\src\\lifeguardScheduler\\employee.text");
		} catch (FileNotFoundException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		schedule.generateSchedule(start, end);
		System.out.println(schedule.daysInPeriod);
		for(day d : schedule.daysInPeriod) {
			System.out.println(d.numGuards);
			for (lifeguard l : d.guardsOnDay) {
				System.out.println(l.name);
			}
		}
		
		
		s.close();
		System.out.println("DONE");
	}
}

