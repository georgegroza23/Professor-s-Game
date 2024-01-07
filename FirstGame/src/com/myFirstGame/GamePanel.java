package com.myFirstGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.myFirstGame.entities.Player;

public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	Thread gameThread;
	int FPS = 60; // frames per second
	Player player = new Player(this);
	
	GamePanel() {
		this.setPreferredSize(new Dimension(640, 695));
		this.setBackground(new Color(247, 173, 100));
		this.setDoubleBuffered(true);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		double drawingInterval = 1_000_000_000 / FPS;
		double nextDrawingMoment = System.nanoTime() + drawingInterval;
		
		while(gameThread != null) {
			player.update();
			repaint();
			
			try {
				double remainingTime = nextDrawingMoment - System.nanoTime();
				remainingTime = remainingTime / 1_000_000;
				
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				nextDrawingMoment = nextDrawingMoment + drawingInterval;
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		player.draw(g2D);
		g2D.dispose();
	}
}
