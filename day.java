package lifeguardScheduler;

import java.util.ArrayList;
import java.util.List;

public class day {
	String name;
	int numGuards;
	int numSG;
	int numGate;
	List<lifeguard> guardsOnDay;
	List<seniorGuard> sgOnDay;
	List<gateGuard> gateOnDay;
	
	
	public day(String name) {
		this.numGate = 0;
		this.name = name;
		this.guardsOnDay = new ArrayList<lifeguard>();
		this.sgOnDay = new ArrayList<seniorGuard>();
		this.gateOnDay = new ArrayList<gateGuard>();
		this.numGuards = guardsOnDay.size();
	}
	
	
	
	
}
