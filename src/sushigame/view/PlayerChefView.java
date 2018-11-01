package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import comp401.sushi.Avocado;
import comp401.sushi.AvocadoPortion;
import comp401.sushi.Eel;
import comp401.sushi.EelPortion;
import comp401.sushi.IngredientPortion;
import comp401.sushi.IngredientPortionImpl;
import comp401.sushi.Nigiri;
import comp401.sushi.Plate;
import comp401.sushi.RedPlate;
import comp401.sushi.Roll;
import comp401.sushi.Sashimi;
import comp401.sushi.SeaweedPortion;
import comp401.sushi.Sushi;
import comp401.sushi.AvocadoPortion;
import comp401.sushi.CrabPortion;
import comp401.sushi.EelPortion;
import comp401.sushi.IngredientPortion;
import comp401.sushi.IngredientPortionImpl;
import comp401.sushi.Nigiri;
import comp401.sushi.Plate;
import comp401.sushi.RedPlate;
import comp401.sushi.RicePortion;
import comp401.sushi.Roll;
import comp401.sushi.SalmonPortion;
import comp401.sushi.Sashimi;
import comp401.sushi.SeaweedPortion;
import comp401.sushi.ShrimpPortion;
import comp401.sushi.Sushi;
import comp401.sushi.TunaPortion;

public class PlayerChefView extends JPanel implements ActionListener, ChangeListener {

	private List<ChefViewListener> listeners;
	private Sushi kmp_roll;
	private Sushi crab_sashimi;
	private Sushi eel_nigiri;
	private int belt_size;
	private Sushi builtSushi;
	
	

	private String[] seafoodTypes = {"", "Crab", "Eel", "Salmon", "Shrimp", "Tuna" };
	
	ButtonGroup colorRadioGroup = new ButtonGroup();
	private ButtonGroup typeRadioGroup = new ButtonGroup();
	JComboBox seafoodBox = new JComboBox(seafoodTypes);

	private JSpinner avocadoSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 999, 0.05));
	private JSpinner crabSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 999, 0.05));
	private JSpinner eelSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 999, 0.05));
	private JSpinner riceSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 999, 0.05));
	private JSpinner salmonSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 999, 0.05));
	private JSpinner seaweedSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 999, 0.05));
	private JSpinner shrimpSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 999, 0.05));
	private JSpinner tunaSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 999, 0.05));
	JSpinner goldSpinner = new JSpinner(new SpinnerNumberModel(5.00, 5.00, 10.00, 0.1));
	
	private int position = 0;
	private JLabel platePos = new JLabel("0");
	
	private SushiGameView gm;
	
	
	
	
	
	
	
	public PlayerChefView(int belt_size, SushiGameView gm) {
		this.gm = gm;
		this.belt_size = belt_size;
		listeners = new ArrayList<ChefViewListener>();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setMinimumSize(new Dimension(300,300));
		this.setPreferredSize(new Dimension(300, 300));
		this.setMaximumSize(new Dimension(300, 300));
		
		
		JPanel plateColor = new JPanel();
		plateColor.setBorder(BorderFactory.createTitledBorder("Choose Your Plate Color"));
		plateColor.setMinimumSize(new Dimension(300,20));
		plateColor.setPreferredSize(new Dimension(300, 20));
		plateColor.setMaximumSize(new Dimension(300, 70));
		JRadioButton redRadio = new JRadioButton("Red");
		redRadio.setForeground(Color.RED);
		JRadioButton greenRadio = new JRadioButton("Green");
		greenRadio.setForeground(Color.GREEN);
		JRadioButton blueRadio = new JRadioButton("Blue");
		blueRadio.setForeground(Color.BLUE);
		JRadioButton goldRadio = new JRadioButton("Gold");
		goldRadio.setForeground(Color.ORANGE); 
					
		colorRadioGroup.add(redRadio);
		colorRadioGroup.add(greenRadio);
		colorRadioGroup.add(blueRadio);
		colorRadioGroup.add(goldRadio);
		
		redRadio.addActionListener(this);
		greenRadio.addActionListener(this);
		blueRadio.addActionListener(this);
		goldRadio.addActionListener(this);
		
		redRadio.setActionCommand("red_plate");
		greenRadio.setActionCommand("green_plate");
		blueRadio.setActionCommand("blue_plate");
		goldRadio.setActionCommand("gold_plate");
		redRadio.setSelected(true);
		
		plateColor.add(redRadio);
		plateColor.add(greenRadio);
		plateColor.add(blueRadio);
		plateColor.add(goldRadio);
		add(plateColor);
		
		
		
		
		
		
		
		JPanel sushiSelector = new JPanel();
		sushiSelector.setBorder(BorderFactory.createTitledBorder("Choose Your Sushi Type"));
		sushiSelector.setMinimumSize(new Dimension(300,20));
		sushiSelector.setPreferredSize(new Dimension(300, 20));
		sushiSelector.setMaximumSize(new Dimension(300, 70));
		JRadioButton nigiriRadio = new JRadioButton("Nigiri");
		JRadioButton sashimiRadio = new JRadioButton("Sashimi");
		JRadioButton rollRadio = new JRadioButton("Roll");
		
				
		typeRadioGroup.add(nigiriRadio);
		typeRadioGroup.add(sashimiRadio);
		typeRadioGroup.add(rollRadio);
		
		nigiriRadio.addActionListener(this);
		sashimiRadio.addActionListener(this);
		rollRadio.addActionListener(this);
		
		nigiriRadio.setActionCommand("nigiri_plate");
		sashimiRadio.setActionCommand("sashimi_plate");
		rollRadio.setActionCommand("roll_plate");
		
		sushiSelector.add(nigiriRadio);
		sushiSelector.add(sashimiRadio);
		sushiSelector.add(rollRadio);
		nigiriRadio.setSelected(true);
		add(sushiSelector);
		
		
		
		
		
		JPanel seafoodSelector = new JPanel();
		seafoodSelector.setBorder(BorderFactory.createTitledBorder("Seafood Type (For Nigir & Sashimi Only)"));
		seafoodSelector.setMinimumSize(new Dimension(300,20));
		seafoodSelector.setPreferredSize(new Dimension(300, 20));
		seafoodSelector.setMaximumSize(new Dimension(300, 70));
		seafoodBox.addActionListener(this);
		seafoodSelector.add(seafoodBox);
		add(seafoodSelector);
		
		
		
		JPanel ingSelector = new JPanel();
		ingSelector.setBorder(BorderFactory.createTitledBorder("Ing Selectors (For Roll Only)"));
		ingSelector.setMinimumSize(new Dimension(300,400));
		ingSelector.setPreferredSize(new Dimension(300, 400));
		ingSelector.setMaximumSize(new Dimension(300, 400));
		ingSelector.setLayout(new GridLayout(0,3));
		
		
		avocadoSpinner.addChangeListener(this);
		crabSpinner.addChangeListener(this);
		eelSpinner.addChangeListener(this);
		riceSpinner.addChangeListener(this);
		salmonSpinner.addChangeListener(this);
		seaweedSpinner.addChangeListener(this);
		shrimpSpinner.addChangeListener(this);
		tunaSpinner.addChangeListener(this);
		
		JLabel oz = new JLabel("  oz");
		
		ingSelector.add(new JLabel("Avocado"));
		ingSelector.add(avocadoSpinner);
		ingSelector.add(oz);
		
		ingSelector.add(new JLabel("Crab"));
		ingSelector.add(crabSpinner);
		ingSelector.add(new JLabel("  oz"));
		
		ingSelector.add(new JLabel("Eel"));
		ingSelector.add(eelSpinner);
		ingSelector.add(new JLabel("  oz"));
		
		ingSelector.add(new JLabel("Rice"));
		ingSelector.add(riceSpinner);
		ingSelector.add(new JLabel("  oz"));
		
		ingSelector.add(new JLabel("Salmon"));
		ingSelector.add(salmonSpinner);
		ingSelector.add(new JLabel("  oz"));
		
		ingSelector.add(new JLabel("Seaweed"));
		ingSelector.add(seaweedSpinner);
		ingSelector.add(new JLabel("  oz"));
		
		ingSelector.add(new JLabel("Shrimp"));
		ingSelector.add(shrimpSpinner);
		ingSelector.add(new JLabel("  oz"));
		
		ingSelector.add(new JLabel("Tuna"));
		ingSelector.add(tunaSpinner);
		ingSelector.add(new JLabel("  oz"));
		
		add(ingSelector);
		
		JPanel goldPricing = new JPanel();
		goldPricing.setBorder(BorderFactory.createTitledBorder("Price for gold plate (if plate is gold)"));
		goldPricing.setMinimumSize(new Dimension(300, 50));
		goldPricing.setPreferredSize(new Dimension(300,50));
		goldPricing.setMaximumSize(new Dimension(300, 50));
		goldPricing.setName("gprice");
		

//		goldSpinner.addChangeListener(this);
		
		goldPricing.add(goldSpinner);
		goldPricing.add(new JLabel("  Dollars  ($5.00 min $10.00 max)"));
		add(goldPricing);
		
		JPanel posPlate = new JPanel();
		posPlate.setBorder(BorderFactory.createTitledBorder("Pick Position to Place Plate"));
		posPlate.setMinimumSize(new Dimension(300, 50));
		posPlate.setPreferredSize(new Dimension(300,50));
		posPlate.setMaximumSize(new Dimension(300, 50));
		
		JSlider positionSlide = new JSlider(JSlider.HORIZONTAL, 0, (belt_size-1), 0);
		positionSlide.addChangeListener(this);
		positionSlide.setName("positionSlide");
		
		posPlate.add(positionSlide);
		posPlate.add(platePos);
		add(posPlate);
		
		JPanel bottomButtons = new JPanel();
		JButton placePlate = new JButton("Place Your Plate");
		bottomButtons.setPreferredSize(new Dimension(300, 50));
		bottomButtons.setMaximumSize(new Dimension(300, 50));
		bottomButtons.setMinimumSize(new Dimension(300, 50));
		placePlate.setActionCommand("PlacePlate");
		placePlate.addActionListener(this);
		placePlate.setHorizontalTextPosition(JLabel.CENTER);
		bottomButtons.add(placePlate);
		
		JButton rotate_button = new JButton("Rotate");
		rotate_button.setActionCommand("rotate");
		rotate_button.addActionListener(this);
		bottomButtons.add(rotate_button);
		
		add(bottomButtons);
		
		
		
		
		
		
	}

	public void registerChefListener(ChefViewListener cl) {
		listeners.add(cl);
	}

	private void makeRedPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleRedPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGreenPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleGreenPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeBluePlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleBluePlateRequest(plate_sushi, plate_position);
		}
	}
	
	private void makeGoldPlateRequest(Sushi plate_sushi, int plate_position, double price) {
		for (ChefViewListener l : listeners) {
			l.handleGoldPlateRequest(plate_sushi, plate_position, price);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("rotate")) {
			gm.rotater();
		}
		
		
		switch (e.getActionCommand()) {

		
		case "PlacePlate":
			
			
			String plateColor = getSelectedButtonText(colorRadioGroup);

			
			String sushiType = getSelectedButtonText(typeRadioGroup);
			
			String seafoodType = String.valueOf(seafoodBox.getSelectedItem());
			
			
			List<IngredientPortion> ingredients = new ArrayList<IngredientPortion>();
			
			
			
			if (((double) avocadoSpinner.getValue() ) > 0) {
			ingredients.add( new AvocadoPortion((double)avocadoSpinner.getValue()));
			}
			
			if (((double) crabSpinner.getValue() ) > 0)
			ingredients.add( new CrabPortion((double)crabSpinner.getValue()));
			
			if (((double) eelSpinner.getValue() ) > 0) {
			ingredients.add( new EelPortion((double)eelSpinner.getValue()));
			}
			if (((double) riceSpinner.getValue() ) > 0) {
			ingredients.add( new RicePortion((double)riceSpinner.getValue()));
			}
			if (((double) salmonSpinner.getValue() ) > 0) {
			ingredients.add( new SalmonPortion((double)salmonSpinner.getValue()));
			}
			if (((double) seaweedSpinner.getValue() ) > 0) {
			ingredients.add( new SeaweedPortion((double)seaweedSpinner.getValue()));
			}
			if (((double) shrimpSpinner.getValue() ) > 0) {
			ingredients.add( new ShrimpPortion((double)shrimpSpinner.getValue()));
			}
			if (((double) tunaSpinner.getValue() ) > 0) {
			ingredients.add( new TunaPortion((double)tunaSpinner.getValue()));
			}
			
			
			IngredientPortion[] finalIngs = ingredients.toArray(new IngredientPortion[ingredients.size()]);
			
			
			switch(sushiType) {
			case "Nigiri":
				if (seafoodType.equals("")) {
					
					JOptionPane.showMessageDialog(null, "Please enter a seafood type for Nigiri or Sashimi");
				} else {
					
						builtSushi = new Nigiri(nigiriType(seafoodType));
				}
				break;
						
			case "Sashimi":
				if (seafoodType.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter a seafood type for Nigiri or Sashimi"); }
				else {
						builtSushi = new Sashimi(sashimiType(seafoodType));
				}
				break;
						
			case "Roll":
				if (finalIngs.length == 0) {
					
					JOptionPane.showMessageDialog(null, "Please add ingredients for your roll");
				} else {
						builtSushi = new Roll("Custom Roll", finalIngs);
				}
			}
			
			
			
			
			double goldPrice = (double) goldSpinner.getValue();
			
			
			
			switch(plateColor) {
			case "Red":
				makeRedPlateRequest(builtSushi, position);
				break;
			case "Green":
				makeGreenPlateRequest(builtSushi, position);
				break;
			case "Blue":
				makeBluePlateRequest(builtSushi, position);
				break;
			case "Gold":
				makeGoldPlateRequest(builtSushi, position, goldPrice);
				break;
			
			}
			
			
			
			
			
			
			}
		} 

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JSlider) {
		JSlider source = (JSlider) e.getSource();
		if( source.getName().equals("positionSlide") ) {
			position = source.getValue();
			platePos.setText(Integer.toString(position));
		}
		}
		
		if (e.getSource() instanceof JSpinner) {
			JSpinner source = (JSpinner) e.getSource();
			if ((double) source.getValue() > 1.5) {
				 JOptionPane.showMessageDialog(null, "Ingredient amount is capped at 1.5oz");
				source.setValue(1.5);
			}
			if ((double) source.getValue() < 0) {
				source.setValue(0);
			}
			
		}
		
		
		
		
	}
	
	private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
	
	private Nigiri.NigiriType nigiriType(String s) {
		switch(s) {
		case "Crab":
			return Nigiri.NigiriType.CRAB;
			
		case "Eel":
			return Nigiri.NigiriType.EEL;
			
		case "Tuna":
			return Nigiri.NigiriType.TUNA;
			
		case "Salmon":
			return Nigiri.NigiriType.SALMON;
			
		case "Shrimp":
			return Nigiri.NigiriType.SHRIMP;
			
		default: 
			return null;
		}
	}
	
	private Sashimi.SashimiType sashimiType(String s) {
		switch(s) {
		case "Crab":
			return Sashimi.SashimiType.CRAB;
			
		case "Eel":
			return Sashimi.SashimiType.EEL;
			
		case "Tuna":
			return Sashimi.SashimiType.TUNA;
			
		case "Salmon":
			return Sashimi.SashimiType.SALMON;
			
		case "Shrimp":
			return Sashimi.SashimiType.SHRIMP;
			
		default: 
			return null;
		}
	}
	
	
}
