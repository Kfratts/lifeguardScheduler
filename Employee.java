package lifeguardScheduler;

import java.util.ArrayList;
import java.util.Scanner;

public class employee {
	private String name;
	private ArrayList<Integer> daysNotAvailable;
	private Integer numDays;

	public employee(String name) {
		this.name = name;
		this.daysNotAvailable = new ArrayList<Integer>();
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

	public Integer getDaysOn() {
		return this.numDays;
	}

}
