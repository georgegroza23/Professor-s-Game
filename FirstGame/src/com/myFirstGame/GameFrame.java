package com.myFirstGame;

import javax.swing.*;

public class GameFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	GamePanel gamePanel;
	
	GameFrame() {
		gamePanel = new GamePanel();
		gamePanel.startGameThread();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Professor Game");
		this.add(gamePanel);
		this.pack();
		this.setLocationRelativeTo(null);
	}
}
