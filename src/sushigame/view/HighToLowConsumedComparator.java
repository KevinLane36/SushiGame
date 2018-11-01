package sushigame.view;

import java.util.Comparator;

import sushigame.model.Chef;

public class HighToLowConsumedComparator  implements Comparator<Chef> {

	@Override
	public int compare(Chef a, Chef b) {
		// TODO Auto-generated method stub
		return b.getNumberConsumed() - a.getNumberConsumed();
	}

}
