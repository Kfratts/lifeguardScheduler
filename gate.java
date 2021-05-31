package lifeguardScheduler;

import java.util.ArrayList;
import java.util.Scanner;

public class gate {
	String name;
	int numDays;
	ArrayList<String> daysNotAvailable;
	String dayNotAvailable;
	
	public gate(String name) {
		this.numDays = 0;
		this.name = name;
		this.daysNotAvailable = new ArrayList<String>();
	}
	/*
	 * Ensures the availability of the employee.
	 * @param none
	 * @return none
	 */
	public void checkAvailability() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the days " + this.name + "is not available. " + "Input the days in the following format: Monday, Tuesday... If the guard is available all days then just press None");
		while(true) {
			this.dayNotAvailable = scan.nextLine();
			if(this.dayNotAvailable == "") {
				break;
			}	
			this.daysNotAvailable.add(this.dayNotAvailable);
		}
	}
}
