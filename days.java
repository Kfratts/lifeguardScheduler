package lifeguardScheduler;

import java.util.ArrayList;
import java.util.List;

public class days {
	String name;
	int numGuards;
	int numSG;
	boolean managerOn;
	boolean gate;
	List<lifeguard> guardsOnDay;
	List<seniorGuard> sgOnDay;
	boolean sgON;
	
	
	public days(String name) {
		this.managerOn = false;
		this.sgON = false;
		this.name = name;
		this.guardsOnDay = new ArrayList<lifeguard>();
		this.sgOnDay = new ArrayList<seniorGuard>();
		this.managerOn = false;
		this.gate = false;
		this.numGuards = guardsOnDay.size();
	}
	
	
	
	
}
