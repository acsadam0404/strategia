package gui;

import java.awt.Graphics;

import javax.swing.*;

/**
 * egy gomb egyedi megjelenéssel, felhasználható JButton helyett
 * XXX még nincs implementálva rendesen 
 * TODO implementálni a stateket, az imageket
 * @author Ács Ádám
 * 2012.07.19.
 */
public class GameButton extends JButton {

	public GameButton(String text) {
		setText(text);
		setBounds(200, 200, 100, 30);
		setIgnoreRepaint(true);
	}
	
	public void draw(Graphics g) {
		paintComponent(g);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	protected void paintBorder(Graphics g) {
		//TODO
		super.paintBorder(g);

	}


}
