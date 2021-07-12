package lifeguardScheduler;

import java.util.ArrayList;
import java.util.List;

public class day {
	int name;
	int numGuards;
	int numSG;
	int numGate;
	int numGuardsPool;
	List<lifeguard> guardsOnDay;
	List<seniorGuard> sgOnDay;
	List<gateGuard> gateOnDay;
	List<lifeguard> guardsAtPool;
	
	
	public day(int day) {
		this.numGate = 0;
		this.name = day;
		this.guardsOnDay = new ArrayList<lifeguard>();
		this.sgOnDay = new ArrayList<seniorGuard>();
		this.gateOnDay = new ArrayList<gateGuard>();
		this.numGuards = guardsOnDay.size();
		this.guardsAtPool = new ArrayList<lifeguard>();
		this.numGuardsPool = guardsAtPool.size();
	}
	
	public void sortLifeguard() {
		for(lifeguard l : guardsOnDay) {
			
		}
	}
	
	
	
}
