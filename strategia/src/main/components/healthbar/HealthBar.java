package components.healthbar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import objects.IDrawable;
import objects.units.Unit;

/**
 * 
 * @author Varga Péter
 * 2012.08.26.
 */
public class HealthBar implements IDrawable {
	
	private Unit unit;
    private Image healthBar;
    
    public HealthBar(Unit unit){
        this.unit = unit;
        healthBar = new ImageIcon("images\\health_bar\\health_bar_transparent1.1.png").getImage();
    }
    
	@Override
	public void draw(Graphics g) {
		g.drawImage(healthBar, unit.getWorldPos().getX(), unit.getWorldPos().getY()  - unit.getUnitData().getHealthBarSize().getY() - 1  /* TODO  hogy fölötte legyen */, null);
		
		for (int i = 0; i < unit.getHealth(); i++) {	
			if(unit.getHealth()>5 && unit.getHealth()<=10){
				g.setColor(new Color(255, 204, 051));
			}
			else if(unit.getHealth()>10){
				g.setColor(new Color( 0, 255, 0));
			}
			else{
				g.setColor(new Color( 255, 0, 0));
			}
			
			g.fillRect(unit.getWorldPos().getX() + 2 /* TODO offset a keret miatt */,
					unit.getWorldPos().getY() + 2 - unit.getUnitData().getHealthBarSize().getY() - 1  /* TODO  hogy fölötte legyen */, 
					i * (unit.getUnitData().getHealthBarSize().getX() - 4 ) / unit.getHealth(), 
					unit.getUnitData().getHealthBarSize().getY() - 4);
			
		}
	}
}
