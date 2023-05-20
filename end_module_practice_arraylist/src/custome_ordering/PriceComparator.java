package custome_ordering;

import java.util.Comparator;

import vehicle.Vehicle;

public class PriceComparator implements Comparator<Vehicle>{

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		if(o1.getNetPrice()>o2.getNetPrice())
			return 1;
		else if(o1.getNetPrice()<o2.getNetPrice())
			return -1;
		return 0;
	}

}
