package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.Plate;

public class IngredientView extends JPanel {

	public IngredientView(Plate p) {
		JFrame extraFrame = new JFrame();
		
		extraFrame.setTitle("IngredientLists");
		setLayout(new BorderLayout());
		display(p);
		extraFrame.setContentPane(this);
		extraFrame.pack();
		extraFrame.setVisible(true);
		}
	
	public void display(Plate p) {
		if (p == null) {
			JPanel infoPanel = new JPanel();
			JLabel empty = new JLabel("No plate is here!");
			empty.setFont(new Font("sans-serif", Font.BOLD, 40));
			infoPanel.add(empty);
			add(infoPanel);
		} else {
		
		JPanel infoPanel =  new JPanel();
		infoPanel.setLayout(new GridLayout(0, 1));
		JLabel rollName = new JLabel();
		rollName.setFont(new Font("Serif", Font.BOLD, 40));
		rollName.setHorizontalAlignment(JLabel.CENTER);
		rollName.setText(p.getContents().getName());
		
		JLabel chef = new JLabel();
		chef.setHorizontalAlignment(JLabel.CENTER);
		rollName.setFont(new Font("Serif", Font.BOLD, 20));
		chef.setText("Chef: " + p.getChef().getName());
//		age.setText("Age: " + age);
		
		infoPanel.add(rollName);
		infoPanel.add(chef);
		
		add(infoPanel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2));
		
		// Header 1
		JLabel name = new JLabel();
		name.setHorizontalAlignment(JLabel.CENTER);
		name.setText("Ingredient Name");
		name.setFont(new Font("Serif", Font.BOLD, 20));
		panel.add(name);
		
		// Header 2
		JLabel amount = new JLabel();
		amount.setHorizontalAlignment(JLabel.CENTER);
		amount.setText("Ingredient Amount");
		amount.setFont(new Font("Serif", Font.BOLD, 20));
		panel.add(amount);
		// Loop for rest of the ingredients
		for (int i = 0; i < p.getContents().getIngredients().length; i++) {
			
			// Name 
			JLabel name2 = new JLabel();
			name2.setHorizontalAlignment(JLabel.CENTER);
			name2.setText(p.getContents().getIngredients()[i].getName());
			name2.setFont(new Font("Serif", Font.PLAIN, 20));
			panel.add(name2);
			
			// Amount
			JLabel amount2 = new JLabel();
			amount2.setHorizontalAlignment(JLabel.CENTER);
			amount2.setText(Math.round((p.getContents().getIngredients()[i].getAmount())*100.0)/100.0 + " oz");
			amount2.setFont(new Font("Serif", Font.PLAIN, 20));
			panel.add(amount2);
		}
			
		add(panel, BorderLayout.CENTER);
		
		revalidate();
		panel.setVisible(true);
		
		
		}
	}
	
	public void refresh(Plate p) {
		
	}

}
