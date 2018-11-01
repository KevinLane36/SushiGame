package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import comp401.sushi.Plate;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.Chef;
import sushigame.model.Customer;
import sushigame.model.HistoricalPlateImpl;
import sushigame.model.PlateEvent;
import sushigame.model.SushiGameModel;

public class ScoreboardWidget extends JPanel implements BeltObserver, ActionListener {

	private SushiGameModel game_model;
	private JLabel display;
	private int chefCount;
	private JLabel[] chefsLabel;
	private JLabel[] counts;
	private Chef[] chefs;
	private String sortBy =  "balance";
	private JLabel header2;
	private JButton ings;

	public ScoreboardWidget(SushiGameModel gm) {
		this.game_model = gm;
		game_model.getBelt().registerBeltObserver(this);
		chefCount= game_model.getOpponentChefs().length + 1;
		this.setMinimumSize(new Dimension(300, 75));
		this.setPreferredSize(new Dimension(300, 75));
		this.setMaximumSize(new Dimension(300, 75));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel heading = new JLabel("Scoreboard                                                                ");
		heading.setFont(new Font("sans-serif", Font.BOLD, 30));
		heading.setHorizontalAlignment(JLabel.LEFT);
		add(heading);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(400, 100));
		buttonPanel.setMinimumSize(new Dimension(400, 100));
		buttonPanel.setMaximumSize(new Dimension(400, 100));
		JButton balanceButton =  new JButton("Chef Balances");
		balanceButton.setActionCommand("balance");
		JButton consumedButton = new JButton("Consumed Plates");
		consumedButton.setActionCommand("consumed");
		JButton spoiledButton = new JButton("Spoiled Plates");
		spoiledButton.setActionCommand("spoiled");

		balanceButton.addActionListener(this);
		consumedButton.addActionListener(this);
		spoiledButton.addActionListener(this);

		buttonPanel.add(balanceButton);
		buttonPanel.add(consumedButton);
		buttonPanel.add(spoiledButton);

		add(buttonPanel);

		JPanel scoreboard = new JPanel();

		scoreboard.setLayout(new GridLayout(0, 2));
		scoreboard.setPreferredSize(new Dimension(400, 300));
		scoreboard.setMinimumSize(new Dimension(400, 300));
		scoreboard.setMaximumSize(new Dimension(400, 300));
		chefsLabel = new JLabel[chefCount];
		counts =  new JLabel[chefCount];

		chefs = new Chef[gm.getOpponentChefs().length + 1];




		JLabel headerChef = new JLabel("Chefs");
		headerChef.setFont(new Font("sans-serif", Font.BOLD, 15));
		scoreboard.add(headerChef);
		header2 = new JLabel("Balance");
		header2.setText("Balance");
		header2.setFont(new Font("sans-serif", Font.BOLD, 15));
		scoreboard.add(header2);

		chefs[0] = gm.getPlayerChef();
		for (int i = 0; i < gm.getOpponentChefs().length; i++) {
			chefs[i+1] =  gm.getOpponentChefs()[i];
		}


		for(int i =  0; i < chefCount; i++)  {
			chefsLabel[i] = new JLabel(chefs[i].getName());
			scoreboard.add(chefsLabel[i]);
			counts[i] = new JLabel("Value Check");
			scoreboard.add(counts[i]);


		}




		ings = new JButton("");
		ings.setVisible(false);
		ings.addActionListener(this);


		add(scoreboard);
		add(ings);

	}


	public void refresh() {


		switch (sortBy) {

		case "balance":
			Arrays.sort(chefs, new HighToLowBalanceComparator());

			header2.setText("Balance");
			ings.setVisible(false);
			for(int i =  0; i < chefCount; i++)  {
				chefsLabel[i].setText(chefs[i].getName());
				counts[i].setText("$" +  (double) (Math.round(chefs[i].getBalance() * 100.00) / 100.00));


			}
			break;

		case "consumed":
			Arrays.sort(chefs, new HighToLowConsumedComparator());


			header2.setText("Consumed Plates");
			ings.setText("Consumed Ingredients");
			ings.setActionCommand("consumedIngs");
			ings.setVisible(true);
			for(int i =  0; i < chefCount; i++)  {
				chefsLabel[i].setText(chefs[i].getName());
				counts[i].setText(String.valueOf(chefs[i].getNumberConsumed()) + " Plates");

			}
			break;

		case "spoiled":
			Arrays.sort(chefs, new HighToLowSpoiledComparator());

			header2.setText("Spoiled Plates");
			ings.setText("Spoiled Ingredients");
			ings.setActionCommand("spoiledIngs");
			ings.setVisible(true);
			for(int i =  0; i < chefCount; i++)  {
				chefsLabel[i].setText(chefs[i].getName());
				counts[i].setText(String.valueOf(chefs[i].getNumberSpoiled()) + " Plates");

			}
			break;


		}

	}

	@Override
	public void handleBeltEvent(BeltEvent e) {
		if (e.getType() == BeltEvent.EventType.ROTATE) {
			refresh();
		}
		if (e.getType() == BeltEvent.EventType.PLATE_CONSUMED) {
			chefs[0] = game_model.getPlayerChef();
			for (int i = 0; i < game_model.getOpponentChefs().length; i++) {
				chefs[i+1] =  game_model.getOpponentChefs()[i];
			}
			refresh();
		} else if (e.getType() == BeltEvent.EventType.PLATE_SPOILED) {
			chefs[0] = game_model.getPlayerChef();
			for (int i = 0; i < game_model.getOpponentChefs().length; i++) {
				chefs[i+1] =  game_model.getOpponentChefs()[i];
			}
			refresh();
			}
}


@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub

	String action = arg0.getActionCommand();
	switch (action) {
	case "balance":
		sortBy = "balance";
		refresh();
		break;
	case "consumed":
		sortBy = "consumed";
		refresh();
		break;
	case "spoiled":
		sortBy = "spoiled";
		refresh();
		break;
	case "consumedIngs":
		refresh();
		JFrame ings_frame = new JFrame();
		ings_frame.setTitle("Consumed Ingredients");


		ings_frame.setContentPane(new IngsScoreboard(game_model, "consumedIngs"));
		ings_frame.pack();
		ings_frame.setVisible(true);
		break;

	case "spoiledIngs":
		JFrame ings_frame2 = new JFrame();
		ings_frame2.setTitle("Spoiled Ingredients");

		ings_frame2.setContentPane(new IngsScoreboard(game_model, "spoiledIngs"));
		ings_frame2.pack();
		ings_frame2.setVisible(true);
		break;


	}
	refresh();


}





}
