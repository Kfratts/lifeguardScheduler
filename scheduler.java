package lifeguardScheduler;

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
		
	
		//Adds members to lifeguard list
		System.out.println("Add lifeguards who will be working for given date range, tap enter when done."); 
		while(s.hasNextLine())
		{
			System.out.print("Add lifeguard: "); 
			schedule.addLifeguard(s.nextLine());
			System.out.println("What dates can " + schedule.getLifeguard(schedule.getLifeguardsSize() - 1) + " not work?"); 
			schedule.getLifeguard(schedule.getLifeguardsSize() -1).addAvailability(); 

		}
		
/*		//Adds members to senior guards list
		System.out.println("Add Senior Guards who will be working for given date range, tap enter when done."); 
		while(s.hasNextLine())
		{
			schedule.seniorGuards.add(new seniorGuard(s.next()));
		}

		//Adds members to gate list
		System.out.println("Add gate guards who will be working for given date range, tap enter when done."); 
		while(s.hasNextLine())
		{
			schedule.gateGuards.add(new gateGuard(s.next()));
		}

		
		//schedule.generateSchedule(start, end);
		}
*/
	}
}

