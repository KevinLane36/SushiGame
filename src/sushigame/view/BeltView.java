package sushigame.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.Plate;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;

public class BeltView extends JPanel implements BeltObserver {

	private Belt belt;
	private BeltWidget beltWidget, beltWidget2;
	
	
	public BeltView(Belt b) {
		this.belt = b;
		belt.registerBeltObserver(this);
		this.beltWidget = new BeltWidget(belt);
		this.setMinimumSize(new Dimension(1000,900));
		this.setPreferredSize(new Dimension(1000, 900));
		this.setMaximumSize(new Dimension(1000, 900));
		add(beltWidget);
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {	
		refresh();
	}

	private void refresh() {
		beltWidget.refresh();
		
	}
}
