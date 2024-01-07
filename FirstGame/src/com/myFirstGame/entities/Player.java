package com.myFirstGame.entities;

import java.awt.Color;
import java.awt.Graphics;

import com.myFirstGame.GamePanel;

public class Player extends Entity{
	//Fields
	GamePanel gamePanel;
	int y = 400;
	
	public Player(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		configureInitialValues();
	}

	// Methods
	private void configureInitialValues() {
		speed = 5;
		direction = "Up";
	}
	
	public void draw(Graphics g2) {
		g2.setColor(Color.orange);
		g2.draw3DRect(10, y, 30, 30, true);
		g2.setColor(Color.white);
		g2.drawRoundRect(50, y, 30, 30, 100, 100);
	}
	
	public void update() {
		y = y - speed;
		if (y == 0) {
			y = 400;
		}
	}
}
