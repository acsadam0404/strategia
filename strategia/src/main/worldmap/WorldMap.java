package worldmap;

import game.core.Game1;
import input.IMouseObserver;
import input.MouseState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import math.Vector2;

import objects.IDrawable;

/**
 * 
 * @author Ács Ádám (aacs)
 * @version 2012.08.09
 */
public class WorldMap implements IDrawable {
    BufferedImage colorImage;
    Image mapImage;
    Color currentColor = Color.BLACK;
    private static Data data = new Data();
   
    public WorldMap() {
        
        try {
            File file = new File("images\\worldmap\\map_color.png");
            colorImage = ImageIO.read(file);
            mapImage = new ImageIcon("images\\worldmap\\map.png").getImage();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawImage(mapImage, 0, 0, null);
       
        Image partImage = null;
       
        partImage = data.imagesByColors.get(currentColor);
       
        if (partImage != null) {
            g.drawImage(partImage, 0, 0, null);
            System.out.println("ittttt");
        }
    }
   
    public Color getColorOnPos(Vector2 p) {
          int clr = colorImage.getRGB(p.getX(), p.getY());
         
          int  red   = (clr & 0x00ff0000) >> 16;
          int  green = (clr & 0x0000ff00) >> 8;
          int  blue  =  clr & 0x000000ff;
         
          Color color = new Color(red, green, blue);
         
          return color;
    }
    
    public void setCurrentColor(Color color) {
    	this.currentColor = color;
    }
    
    private static class Data {
        public final Map<Color, Image> imagesByColors = new HashMap<>();
        
        public Data() {
        	setImagesByColorsMap();
        }
        
    	private void setImagesByColorsMap() {
            imagesByColors.put(new Color(186, 242, 211), new ImageIcon("images\\worldmap\\1.png").getImage());
            imagesByColors.put(new Color(148, 0, 0), new ImageIcon("images\\worldmap\\2.png").getImage());
            imagesByColors.put(new Color(30, 52, 17), new ImageIcon("images\\worldmap\\3.png").getImage());
            imagesByColors.put(new Color(137, 0, 243), new ImageIcon("images\\worldmap\\4.png").getImage());
            imagesByColors.put(new Color(200, 243, 0), new ImageIcon("images\\worldmap\\5.png").getImage());
            imagesByColors.put(new Color(243, 86, 0), new ImageIcon("images\\worldmap\\6.png").getImage());
            imagesByColors.put(new Color(243, 0, 154), new ImageIcon("images\\worldmap\\7.png").getImage());
            imagesByColors.put(new Color(204, 98, 148), new ImageIcon("images\\worldmap\\8.png").getImage());
            imagesByColors.put(new Color(49, 209, 173), new ImageIcon("images\\worldmap\\9.png").getImage());
            imagesByColors.put(new Color(147, 209, 49), new ImageIcon("images\\worldmap\\10.png").getImage());
            
        }
    }
}

