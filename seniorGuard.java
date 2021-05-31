package lifeguardScheduler;

import java.util.ArrayList;
import java.util.Scanner;

public class seniorGuard {
	String name;
	int numDays;
	boolean sgON;
	ArrayList<String> daysNotAvailable;
	String dayNotAvailable;
	
	
	public seniorGuard(String name) {
		this.name = name;
		this.daysNotAvailable = new ArrayList<String>();
	}	
	public void SGcheckAvailability() {
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
