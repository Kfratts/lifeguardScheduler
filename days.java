package lifeguardScheduler;

import java.util.ArrayList;
import java.util.List;

public class days {
	String name;
	int numGuards;
	boolean managerOn;
	boolean gate;
	List<lifeguard> guardsOnDay;
	
	
	public days(String name) {
		this.name = name;
		this.guardsOnDay = new ArrayList<lifeguard>();
		this.managerOn = false;
		this.gate = false;
		this.numGuards = guardsOnDay.size();
	}
	
	
	
	
}
