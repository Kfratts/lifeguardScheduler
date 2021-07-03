package lifeguardScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class employee {
	String name;
	List<day> daysNotAvailable;
	Integer numDays;

	public employee(String name) {
		this.name = name;
		this.daysNotAvailable = new ArrayList<day>();
		this.numDays = 0;
	}

	public void addAvailability() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the dates " + this.name + "is not available. "
				+ "Input the dates one at a time, pressing enter at the end.  Once done or if they can work all days, press enter on a blank line.");
		while (scan.hasNextInt()) {
			this.daysNotAvailable.add(scan.nextInt());
		}
	}

	// getter methods
	public String getName() {
		return this.name;
	}
	public int getNumDays() {
		return this.numDays;
	}
	public Integer getDaysOn() {
		return this.numDays;
	}

}
