package sushigame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.Nigiri;
import comp401.sushi.Plate;
import comp401.sushi.Sashimi;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;

public class CircleCreator extends JPanel implements BeltObserver {

	private Belt belt;
	private JLabel plateInfo;
	private JLabel index;
	private JLabel chef;
	private JLabel age;
	private JLabel type;
	private CirclePanel circle;
	private Plate p;

	public CircleCreator(int i, Belt b) {
		this.belt = b;
		this.p = b.getPlateAtPosition(i);
		GridLayout layout = new GridLayout(8, 1);
		layout.setVgap(0);
		layout.setHgap(10);
		this.setLayout(layout);
		CirclePanel circle = new CirclePanel(Color.BLACK);
		if (b.getPlateAtPosition(i) != null) {
			if (b.getPlateAtPosition(i).getColor() == Plate.Color.BLUE) {
				circle = new CirclePanel(Color.BLUE);
			} else if (b.getPlateAtPosition(i).getColor() == Plate.Color.RED) {
				circle = new CirclePanel(Color.RED);
			} else if (b.getPlateAtPosition(i).getColor() == Plate.Color.GREEN) {
				circle = new CirclePanel(Color.GREEN);
			} else {
				circle = new CirclePanel(Color.YELLOW);
			}
		}
		this.circle = circle;
		this.add(circle);
		
		JLabel whiteSpace1 = new JLabel();
		whiteSpace1.setSize(300,100);
		this.add(whiteSpace1);
		
		JLabel index = new JLabel();
		index.setText("Plate " + i);
		index.setSize(new Dimension(300, 10));
		this.index = index;
		this.add(index);

		JLabel type = new JLabel();
		type.setText("");
		type.setSize(new Dimension(300, 100));
		this.type = type;
		this.add(type);

		JLabel plateInfo = new JLabel();
		plateInfo.setText("Plate Empty");
		plateInfo.setSize(new Dimension(300, 10));
		this.plateInfo = plateInfo;
		this.add(plateInfo);
		
		
		JLabel chef = new JLabel();
		chef.setText("Chef");
		chef.setSize(new Dimension(300, 10));
		this.chef = chef;
		this.add(chef);
		
		JLabel age = new JLabel();
		age.setText("Chef");
		age.setSize(new Dimension(300, 10));
		this.age = age;
		this.add(age);
		
		
		JLabel whiteSpace = new JLabel();
		whiteSpace.setSize(300,100);
		this.add(whiteSpace);

	}

	public void handleBeltEvent(BeltEvent e) {
		// TODO Auto-generated method stub

	}

	public void refresh(Plate p, int age) {
		if (p == null) {
			plateInfo.setText("Plate Empty");
			this.age.setText("");
			this.chef.setText("");
			this.type.setText("");
			
			circle.refresh(null);
		} else {
			
			// check to see if it is roll, sashimi, or nigiri
			if (p.getContents().getSushiType().equals("nigiri")) {
				plateInfo.setText("Nigiri");
				type.setText(p.getContents().getIngredients()[0].getName());
			} else if (p.getContents().getSushiType().equals("sashimi")) {
				plateInfo.setText("Sashimi");
				type.setText(p.getContents().getIngredients()[0].getName());
			} else {
				this.type.setText("roll");
				plateInfo.setText(p.getContents().getName());
			}
			infoGen(p, age);
			circle.refresh(p);
		}

	}

	private void infoGen(Plate p, int age) {
		this.age.setText("Age: " + age);
		this.chef.setText(p.getChef().getName());

	}

}
