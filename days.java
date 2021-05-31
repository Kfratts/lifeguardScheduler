package lifeguardScheduler;

import java.util.ArrayList;
import java.util.List;

public class days {
	String name;
	int numGuards;
	int numSG;
	int numGate;
	List<lifeguard> guardsOnDay;
	List<seniorGuard> sgOnDay;
	List<gate> gateOnDay;
	
	
	public days(String name) {
		this.numGate = 0;
		this.name = name;
		this.guardsOnDay = new ArrayList<lifeguard>();
		this.sgOnDay = new ArrayList<seniorGuard>();
		this.gateOnDay = new ArrayList<gate>();
		this.numGuards = guardsOnDay.size();
	}
	
	
	
	
}
