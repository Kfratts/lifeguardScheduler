package lifeguardScheduler;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	String name;
	List<day> daysNotAvailable;
	Integer numDays;

	public Employee(String name) {
		this.name = name;
		this.daysNotAvailable = new ArrayList<day>();
		this.numDays = 0;
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
