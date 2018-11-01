package sushigame.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import comp401.sushi.Plate;

public class CirclePanel extends JPanel {
	private Color color;
	
	public CirclePanel(Color color)  {
		this.color = color;
	}
    public void paint(Graphics g) {
        
		setSize(50, 50);
		
		g.drawOval(50, 50, 50, 50);
        
        g.setColor(color);
        
        g.fillOval(0, 0, 50, 50);
    }
    
    public void paintIt(Graphics g) {
        
  		setSize(30, 30);
  		
          
          g.setColor(color);
          
          g.fillOval(0, 0, 50, 50);
      }
      
    
public void setColor(Color cc) {
	this.color = cc;
    }

public void refresh(Plate p) {
	Color cc = Color.BLACK;
	if (p == null) {
	} else {
	if (p.getColor() == Plate.Color.BLUE) {
		cc = Color.BLUE;
	}
	if (p.getColor() == Plate.Color.GREEN) {
		cc = Color.GREEN;
	}
	if (p.getColor() == Plate.Color.RED) {
		cc = Color.RED;
	}
	if (p.getColor() == Plate.Color.GOLD) {
		cc = Color.YELLOW;
	}
	}
	setColor(cc);
	repaint();
}
    
}