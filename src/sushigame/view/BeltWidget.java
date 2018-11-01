package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.Plate;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;

import sushigame.model.BeltObserver;

public class BeltWidget extends JPanel implements BeltObserver {
	
	private Belt belt;
	private JPanel[] belt_circle;
	private IngredientView view;
	private List<IngredientListener> listeners = new ArrayList<IngredientListener>();

	public BeltWidget(Belt b) {
		
		
		this.belt = b;
		belt.registerBeltObserver(this);
		
		
		JPanel upperBelt = new JPanel();
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		GridLayout layout = new GridLayout(2, belt.getSize() / 2);
		layout.setHgap(30);
		upperBelt.setLayout(layout);
		belt_circle = new JPanel[belt.getSize()];
		
		
		
		for (int i = 0; i < belt.getSize(); i++) {
//			JLabel plabel = new JLabel("");
			this.setMinimumSize(new Dimension(1000, 500));
			this.setPreferredSize(new Dimension(1000, 500));
//			plabel.setOpaque(true);
//			plabel.setBackground(Color.GRAY);
			JPanel circle = new CircleCreator(i, belt);
			Plate p = belt.getPlateAtPosition(i);
			circle.setSize(500,500);
			IngredientListener temp =  new IngredientListener(p, this);
			circle.addMouseListener(temp);
			listeners.add(temp);
			upperBelt.add(circle);
			upperBelt.setVisible(true);
			belt_circle[i] = circle;
		}
		JLabel instruc = new JLabel();
		instruc.setText("Click on a plate to view it's ingredients!" + "                                                                    ");
		instruc.setHorizontalAlignment(JLabel.LEFT);
		instruc.setVerticalAlignment(JLabel.NORTH);
		instruc.setFont(new Font("Serif", Font.BOLD, 30));
		this.add(instruc);
		this.add(upperBelt);
		this.setMinimumSize(new Dimension(1000,500));
		this.setPreferredSize(new Dimension(1000, 500));
		this.setMaximumSize(new Dimension(1000, 500));
		refresh();
	}

	public void handleBeltEvent(BeltEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void refresh() {
		for (int i=0; i<belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) == null) {
				Plate d = null;
				JPanel circle = belt_circle[i];
				((CircleCreator) circle).refresh(d, 0);
			} else {
			Plate p = belt.getPlateAtPosition(i);
			int age = belt.getAgeOfPlateAtPosition(i);
			JPanel circle = belt_circle[i];
			((CircleCreator) circle).refresh(p, age);
			}
		}
		
		int i = 0;
		for (IngredientListener e: listeners) {
			e.refresh(belt.getPlateAtPosition(i));
			i++;
		}
	}
	
	public void mouseClick(Plate p) {
		this.view = new IngredientView(p);
	}
	

}
