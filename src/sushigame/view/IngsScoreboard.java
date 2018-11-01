package sushigame.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.Plate;
import sushigame.model.Chef;
import sushigame.model.HistoricalPlate;
import sushigame.model.SushiGameModel;

public class IngsScoreboard extends JPanel {


	private SushiGameModel gm;
	private String type;
	private int chefCount;
	private Chef[] chefs;
	private JLabel[] avo;
	private JLabel[] crab;
	private JLabel[] eel;
	private JLabel[] rice;
	private JLabel[] salmon;
	private JLabel[] seaweed;
	private JLabel[] shrimp;
	private JLabel[] tuna;
	private double[] chefTotals;
	





	public IngsScoreboard(SushiGameModel gm, String type) {
		this.gm = gm;
		this.type = type;
		chefCount= gm.getOpponentChefs().length + 1;
		GridLayout layout = new GridLayout(0, 7);
		layout.setHgap(30);
		layout.setVgap(20);
		this.setLayout(layout);
		JLabel ings = new JLabel("Ingredients");
		ings.setFont(new Font("sans-serif", Font.BOLD, 15));
		add(ings);
		chefs = new Chef[gm.getOpponentChefs().length + 1];

		chefs[0] = gm.getPlayerChef();
		for (int i = 0; i < gm.getOpponentChefs().length; i++) {
			chefs[i+1] =  gm.getOpponentChefs()[i];
		}
		
		
		avo = new JLabel[chefCount + 1];
		crab = new JLabel[chefCount + 1];
		eel = new JLabel[chefCount + 1];
		rice = new JLabel[chefCount + 1];
		salmon = new JLabel[chefCount + 1];
		seaweed = new JLabel[chefCount + 1];
		shrimp = new JLabel[chefCount + 1];
		tuna = new JLabel[chefCount + 1];
		
		
		
		
		
		
		
		
		if (type.equals("consumedIngs")) {
			
			chefTotals = new double[chefCount];
			
			
			
			for (int i = 0; i < chefCount; i++) {
				JLabel c = new JLabel(chefs[i].getName());
				c.setFont(new Font("sans-serif", Font.BOLD, 15));
				add(c);
				chefTotals[i] = 0;
			}
			JLabel t = new JLabel("Totals");
			t.setFont(new Font("sans-serif", Font.BOLD, 15));
			add(t);
			// Avocado
			JLabel a = new JLabel("Avocado");
			a.setFont(new Font("sans-serif", Font.BOLD, 15));
			add(a);
			double avoTotal = 0;
			for (int i = 0; i <= chefCount; i++) {
				if (i == chefCount) {
					avo[i] = new JLabel((double) (Math.round(avoTotal * 100.00) / 100.00) + " oz");
					add(avo[i]);
				} else {
					double avoAmt = 0;
					if (!(chefs[i].getPlateHistory() == null)) {
					List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
					
					for (int g = 0; g < oldPlates.size(); g++) {
					
						if (!oldPlates.get(g).wasSpoiled()) {
							for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
							if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("avocado")) {
							avoAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							avoTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							}
							
							}
						}
					
					}
					}
				avo[i] = new JLabel((double) (Math.round(avoAmt * 100.00) / 100.00) + " oz");
				add(avo[i]);
				chefTotals[i] += avoAmt;
				}
				
				
			}
			
			// Crab
			JLabel cc = new JLabel("Crab");
			cc.setFont(new Font("sans-serif", Font.BOLD, 15));
			add(cc);
			double crabTotal = 0;
			for (int i = 0; i <= chefCount; i++) {
				if (i == chefCount) {
					crab[i] = new JLabel((double) (Math.round(crabTotal * 100.00) / 100.00) + " oz");
					add(crab[i]);
				} else {
					double crabAmt = 0;
					if (!(chefs[i].getPlateHistory() == null)) {
					List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
					
					for (int g = 0; g < oldPlates.size(); g++) {
					
						if (!oldPlates.get(g).wasSpoiled()) {
							for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
							if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("crab")) {
							crabAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							crabTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							}
							
							}
						}
					
					}
					}
				crab[i] = new JLabel(((double) (Math.round(crabAmt * 100.00) / 100.00) + " oz"));
				add(crab[i]);
				chefTotals[i] += crabAmt;
				}
			}
			
			
			// Eel
			JLabel e = new JLabel("Eel");
			e.setFont(new Font("sans-serif", Font.BOLD, 15));
			add(e);
			double eelTotal = 0;
			for (int i = 0; i <= chefCount; i++) {
				if (i == chefCount) {
					eel[i] = new JLabel((double) (Math.round(eelTotal * 100.00) / 100.00) + " oz");
					add(eel[i]);
				} else {
					double eelAmt = 0;
					if (!(chefs[i].getPlateHistory() == null)) {
					List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
					
					for (int g = 0; g < oldPlates.size(); g++) {
					
						if (!oldPlates.get(g).wasSpoiled()) {
							for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
							if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("eel")) {
							eelAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							eelTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							}
							
							}
						}
					
					}
					}
				eel[i] = new JLabel(((double) (Math.round(eelAmt * 100.00) / 100.00) + " oz"));
				add(eel[i]);
				chefTotals[i] += eelAmt;
				}
			}
			
			// Rice
			JLabel r = new JLabel("Rice");
			r.setFont(new Font("sans-serif", Font.BOLD, 15));
			add(r);
			double riceTotal = 0;
			for (int i = 0; i <= chefCount; i++) {
				if (i == chefCount) {
					rice[i] = new JLabel((double) (Math.round(riceTotal * 100.00) / 100.00)+ " oz");
					add(rice[i]);
				} else {
					double riceAmt = 0;
					if (!(chefs[i].getPlateHistory() == null)) {
					List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
					
					for (int g = 0; g < oldPlates.size(); g++) {
					
						if (!oldPlates.get(g).wasSpoiled()) {
							for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
							if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("rice")) {
							riceAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							riceTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							}
							
							}
						}
					
					}
					}
				rice[i] = new JLabel(((double) (Math.round(riceAmt * 100.00) / 100.00) + " oz"));
				add(rice[i]);
				chefTotals[i] += riceAmt;
				}
			}
			
			// Salmon
			JLabel s = new JLabel("Salmon");
			s.setFont(new Font("sans-serif", Font.BOLD, 15));
			add(s);
			double salmonTotal = 0;
			for (int i = 0; i <= chefCount; i++) {
				if (i == chefCount) {
					salmon[i] = new JLabel((double) (Math.round(salmonTotal * 100.00) / 100.00) + " oz");
					add(salmon[i]);
				} else {
					double salmonAmt = 0;
					if (!(chefs[i].getPlateHistory() == null)) {
					List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
					
					for (int g = 0; g < oldPlates.size(); g++) {
					
						if (!oldPlates.get(g).wasSpoiled()) {
							for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
							if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("salmon")) {
							salmonAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							salmonTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							}
							
							}
						}
					
					}
					}
				salmon[i] = new JLabel(((double) (Math.round(salmonAmt * 100.00) / 100.00) + " oz"));
				add(salmon[i]);
				chefTotals[i] += salmonAmt;
				}
			}
			// seaweed
			JLabel ss = new JLabel("Seaweed");
			ss.setFont(new Font("sans-serif", Font.BOLD, 15));
			add(ss);
			double seaweedTotal = 0;
			for (int i = 0; i <= chefCount; i++) {
				if (i == chefCount) {
					seaweed[i] = new JLabel((double) (Math.round(seaweedTotal * 100.00) / 100.00) + " oz");
					add(seaweed[i]);
				} else {
					double seaweedAmt = 0;
					if (!(chefs[i].getPlateHistory() == null)) {
					List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
					
					for (int g = 0; g < oldPlates.size(); g++) {
					
						if (!oldPlates.get(g).wasSpoiled()) {
							for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
							if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("seaweed")) {
							seaweedAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							seaweedTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							}
							
							}
						}
					
					}
					}
				seaweed[i] = new JLabel(((double) (Math.round(seaweedAmt * 100.00) / 100.00) + " oz"));
				add(seaweed[i]);
				chefTotals[i] += seaweedAmt;
				}
			}
			// Shrimp
			JLabel sss = new JLabel("Shrimp");
			sss.setFont(new Font("sans-serif", Font.BOLD, 15));
			add(sss);
			double shrimpTotal = 0;
			for (int i = 0; i <= chefCount; i++) {
				if (i == chefCount) {
					shrimp[i] = new JLabel((double) (Math.round(shrimpTotal * 100.00) / 100.00) + " oz");
					add(shrimp[i]);
				} else {
					double shrimpAmt = 0;
					if (!(chefs[i].getPlateHistory() == null)) {
					List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
					
					for (int g = 0; g < oldPlates.size(); g++) {
					
						if (!oldPlates.get(g).wasSpoiled()) {
							for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
							if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("shrimp")) {
							shrimpAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							shrimpTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							}
							
							}
						}
					
					}
					}
				shrimp[i] = new JLabel(((double) (Math.round(shrimpAmt * 100.00) / 100.00) + " oz"));
				add(shrimp[i]);
				chefTotals[i] += shrimpAmt;
				}
			}
			// Tuna
			JLabel tt = new JLabel("Tuna");
			tt.setFont(new Font("sans-serif", Font.BOLD, 15));
			add(tt);
			double tunaTotal = 0;
			for (int i = 0; i <= chefCount; i++) {
				if (i == chefCount) {
					tuna[i] = new JLabel((double) (Math.round(tunaTotal * 100.00) / 100.00) + " oz");
					add(tuna[i]);
				} else {
					double tunaAmt = 0;
					if (!(chefs[i].getPlateHistory() == null)) {
					List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
					
					for (int g = 0; g < oldPlates.size(); g++) {
					
						if (!oldPlates.get(g).wasSpoiled()) {
							for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
							if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("tuna")) {
							tunaAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							tunaTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
							}
							
							}
						}
					
					}
					}
				tuna[i] = new JLabel(((double) (Math.round(tunaAmt * 100.00) / 100.00) + " oz"));
				add(tuna[i]);
				chefTotals[i] += tunaAmt;
				}
			}
			
			
			add(new JLabel("Chef Totals"));
			double total = 0;
			for (int h = 0; h < chefTotals.length; h++) {
				add(new JLabel((double) (Math.round(chefTotals[h] * 100.00) / 100.00) + " oz"));
				total += chefTotals[h];
			}
			
			
			add(new JLabel((double) (Math.round(total * 100.00) / 100.00) + " oz"));
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		if (type.equals("spoiledIngs")) {
				
				chefTotals = new double[chefCount];
				
				
				
				for (int i = 0; i < chefCount; i++) {
					JLabel c = new JLabel(chefs[i].getName());
					c.setFont(new Font("sans-serif", Font.BOLD, 15));
					add(c);
					chefTotals[i] = 0;
				}
				JLabel t = new JLabel("Totals");
				t.setFont(new Font("sans-serif", Font.BOLD, 15));
				add(t);
				// Avocado
				JLabel a = new JLabel("Avocado");
				a.setFont(new Font("sans-serif", Font.BOLD, 15));
				add(a);
				double avoTotal = 0;
				for (int i = 0; i <= chefCount; i++) {
					if (i == chefCount) {
						avo[i] = new JLabel((double) (Math.round(avoTotal * 100.00) / 100.00) + " oz");
						add(avo[i]);
					} else {
						double avoAmt = 0;
						if (!(chefs[i].getPlateHistory() == null)) {
						List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
						
						for (int g = 0; g < oldPlates.size(); g++) {
						
							if (oldPlates.get(g).wasSpoiled()) {
								for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
								if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("avocado")) {
								avoAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								avoTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								}
								
								}
							}
						
						}
						}
					avo[i] = new JLabel((double) (Math.round(avoAmt * 100.00) / 100.00) + " oz");
					add(avo[i]);
					chefTotals[i] += avoAmt;
					}
					
					
				}
				
				// Crab
				JLabel cc = new JLabel("Crab");
				cc.setFont(new Font("sans-serif", Font.BOLD, 15));
				add(cc);
				double crabTotal = 0;
				for (int i = 0; i <= chefCount; i++) {
					if (i == chefCount) {
						crab[i] = new JLabel((double) (Math.round(crabTotal * 100.00) / 100.00) + " oz");
						add(crab[i]);
					} else {
						double crabAmt = 0;
						if (!(chefs[i].getPlateHistory() == null)) {
						List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
						
						for (int g = 0; g < oldPlates.size(); g++) {
						
							if (oldPlates.get(g).wasSpoiled()) {
								for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
								if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("crab")) {
								crabAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								crabTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								}
								
								}
							}
						
						}
						}
					crab[i] = new JLabel(((double) (Math.round(crabAmt * 100.00) / 100.00) + " oz"));
					add(crab[i]);
					chefTotals[i] += crabAmt;
					}
				}
				
				
				// Eel
				JLabel e = new JLabel("Eel");
				e.setFont(new Font("sans-serif", Font.BOLD, 15));
				add(e);
				double eelTotal = 0;
				for (int i = 0; i <= chefCount; i++) {
					if (i == chefCount) {
						eel[i] = new JLabel((double) (Math.round(eelTotal * 100.00) / 100.00) + " oz");
						add(eel[i]);
					} else {
						double eelAmt = 0;
						if (!(chefs[i].getPlateHistory() == null)) {
						List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
						
						for (int g = 0; g < oldPlates.size(); g++) {
						
							if (oldPlates.get(g).wasSpoiled()) {
								for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
								if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("eel")) {
								eelAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								eelTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								}
								
								}
							}
						
						}
						}
					eel[i] = new JLabel(((double) (Math.round(eelAmt * 100.00) / 100.00) + " oz"));
					add(eel[i]);
					chefTotals[i] += eelAmt;
					}
				}
				
				// Rice
				JLabel r = new JLabel("Rice");
				r.setFont(new Font("sans-serif", Font.BOLD, 15));
				add(r);
				double riceTotal = 0;
				for (int i = 0; i <= chefCount; i++) {
					if (i == chefCount) {
						rice[i] = new JLabel((double) (Math.round(riceTotal * 100.00) / 100.00)+ " oz");
						add(rice[i]);
					} else {
						double riceAmt = 0;
						if (!(chefs[i].getPlateHistory() == null)) {
						List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
						
						for (int g = 0; g < oldPlates.size(); g++) {
						
							if (oldPlates.get(g).wasSpoiled()) {
								for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
								if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("rice")) {
								riceAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								riceTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								}
								
								}
							}
						
						}
						}
					rice[i] = new JLabel(((double) (Math.round(riceAmt * 100.00) / 100.00) + " oz"));
					add(rice[i]);
					chefTotals[i] += riceAmt;
					}
				}
				
				// Salmon
				JLabel s = new JLabel("Salmon");
				s.setFont(new Font("sans-serif", Font.BOLD, 15));
				add(s);
				double salmonTotal = 0;
				for (int i = 0; i <= chefCount; i++) {
					if (i == chefCount) {
						salmon[i] = new JLabel((double) (Math.round(salmonTotal * 100.00) / 100.00) + " oz");
						add(salmon[i]);
					} else {
						double salmonAmt = 0;
						if (!(chefs[i].getPlateHistory() == null)) {
						List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
						
						for (int g = 0; g < oldPlates.size(); g++) {
						
							if (oldPlates.get(g).wasSpoiled()) {
								for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
								if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("salmon")) {
								salmonAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								salmonTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								}
								
								}
							}
						
						}
						}
					salmon[i] = new JLabel(((double) (Math.round(salmonAmt * 100.00) / 100.00) + " oz"));
					add(salmon[i]);
					chefTotals[i] += salmonAmt;
					}
				}
				// seaweed
				JLabel ss = new JLabel("Seaweed");
				ss.setFont(new Font("sans-serif", Font.BOLD, 15));
				add(ss);
				double seaweedTotal = 0;
				for (int i = 0; i <= chefCount; i++) {
					if (i == chefCount) {
						seaweed[i] = new JLabel((double) (Math.round(seaweedTotal * 100.00) / 100.00) + " oz");
						add(seaweed[i]);
					} else {
						double seaweedAmt = 0;
						if (!(chefs[i].getPlateHistory() == null)) {
						List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
						
						for (int g = 0; g < oldPlates.size(); g++) {
						
							if (oldPlates.get(g).wasSpoiled()) {
								for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
								if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("seaweed")) {
								seaweedAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								seaweedTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								}
								
								}
							}
						
						}
						}
					seaweed[i] = new JLabel(((double) (Math.round(seaweedAmt * 100.00) / 100.00) + " oz"));
					add(seaweed[i]);
					chefTotals[i] += seaweedAmt;
					}
				}
				// Shrimp
				JLabel sss = new JLabel("Shrimp");
				sss.setFont(new Font("sans-serif", Font.BOLD, 15));
				add(sss);
				double shrimpTotal = 0;
				for (int i = 0; i <= chefCount; i++) {
					if (i == chefCount) {
						shrimp[i] = new JLabel((double) (Math.round(shrimpTotal * 100.00) / 100.00) + " oz");
						add(shrimp[i]);
					} else {
						double shrimpAmt = 0;
						if (!(chefs[i].getPlateHistory() == null)) {
						List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
						
						for (int g = 0; g < oldPlates.size(); g++) {
						
							if (oldPlates.get(g).wasSpoiled()) {
								for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
								if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("shrimp")) {
								shrimpAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								shrimpTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								}
								
								}
							}
						
						}
						}
					shrimp[i] = new JLabel(((double) (Math.round(shrimpAmt * 100.00) / 100.00) + " oz"));
					add(shrimp[i]);
					chefTotals[i] += shrimpAmt;
					}
				}
				// Tuna
				JLabel tt = new JLabel("Tuna");
				tt.setFont(new Font("sans-serif", Font.BOLD, 15));
				add(tt);
				double tunaTotal = 0;
				for (int i = 0; i <= chefCount; i++) {
					if (i == chefCount) {
						tuna[i] = new JLabel((double) (Math.round(tunaTotal * 100.00) / 100.00) + " oz");
						add(tuna[i]);
					} else {
						double tunaAmt = 0;
						if (!(chefs[i].getPlateHistory() == null)) {
						List<HistoricalPlate> oldPlates = chefs[i].getPlateHistory();
						
						for (int g = 0; g < oldPlates.size(); g++) {
						
							if (oldPlates.get(g).wasSpoiled()) {
								for (int x = 0; x < oldPlates.get(g).getContents().getIngredients().length; x++) {
								if (oldPlates.get(g).getContents().getIngredients()[x].getName().equals("tuna")) {
								tunaAmt += oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								tunaTotal +=oldPlates.get(g).getContents().getIngredients()[x].getAmount();
								}
								
								}
							}
						
						}
						}
					tuna[i] = new JLabel(((double) (Math.round(tunaAmt * 100.00) / 100.00) + " oz"));
					add(tuna[i]);
					chefTotals[i] += tunaAmt;
					}
				}
				
				
				add(new JLabel("Chef Totals"));
				double total = 0;
				for (int h = 0; h < chefTotals.length; h++) {
					add(new JLabel((double) (Math.round(chefTotals[h] * 100.00) / 100.00) + " oz"));
					total += chefTotals[h];
				}
				
				
				add(new JLabel((double) (Math.round(total * 100.00) / 100.00) + " oz"));
				
				
				
			
		}
	}



	}
