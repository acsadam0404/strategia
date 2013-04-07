package gui;

import java.awt.Graphics;

import javax.swing.*;

/**
 * egy gomb egyedi megjelen�ssel, felhaszn�lhat� JButton helyett
 * XXX m�g nincs implement�lva rendesen 
 * TODO implement�lni a stateket, az imageket
 * @author �cs �d�m
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
