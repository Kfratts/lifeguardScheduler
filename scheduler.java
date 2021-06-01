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
		employeeFile.createFileAndInitialize();
		s.close();
	}
}

