package sushigame.model;

import java.util.ArrayList;
import java.util.List;

import comp401.sushi.Plate;
import comp401.sushi.Sushi;
import comp401.sushi.Plate.Color;

public interface Chef {

	String getName();
	void setName(String name);

	void makeAndPlacePlate(Plate plate, int position) 
			throws InsufficientBalanceException, BeltFullException, AlreadyPlacedThisRotationException;

	List<HistoricalPlate> getPlateHistory(int max_history_length);
	List<HistoricalPlate> getPlateHistory();

	double getBalance();
	
	int getNumberConsumed();

	int getNumberSpoiled();
	
	boolean alreadyPlacedThisRotation();

}

