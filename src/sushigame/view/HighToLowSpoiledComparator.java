package sushigame.view;

import java.util.Comparator;

import sushigame.model.Chef;

public class HighToLowSpoiledComparator  implements Comparator<Chef> {

	@Override
	public int compare(Chef a, Chef b) {
		// TODO Auto-generated method stub
		return a.getNumberSpoiled() - b.getNumberSpoiled();
	}

}
