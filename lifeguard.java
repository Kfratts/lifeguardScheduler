package lifeguardScheduler;

import java.util.Scanner; 
import java.util.ArrayList;

public class lifeguard {
	String name;
	String dayNotAvailable;
	ArrayList<String> daysNotAvailable;
	int maxNumDays;
	boolean noMoreDays;
	int numDays;

	public lifeguard(String name) {
		this.name = name;
		this.daysNotAvailable = new ArrayList<String>();
		this.maxNumDays = 5;
		this.noMoreDays = false;
		this.numDays = 0;
	}
	
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
