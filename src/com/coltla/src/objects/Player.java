package com.coltla.src.objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import com.coltla.src.GlobalPosition;
import com.coltla.src.MainClass;
import com.coltla.src.input.Controller;

public class Player extends GlobalPosition {
	
	private String playerImage = "/images/player.png";
	private int velX = 0;
	private int velY = 0;
	private int frameWidth;
	private int frameHeight;
	int imageWidth = 44;
	int imageHeight = 70;
	
	private static LinkedList<Enemy> enemies = Controller.getEnemies();

	
	public Player(int x, int y) {
		super(x, y);
		this.frameWidth = MainClass.WIDTH;
		this.frameHeight = MainClass.HEIGHT;
		
		System.out.println("player w " + frameWidth + " player h " + frameHeight);
	}

	public void update() {
		x += velX;
		y += velY;
		
		// Collision with boundaries
		if (x < -2) {
			x = -2;
		}
		if (y < -5) {
			y = -5;
		}
		if (x > frameWidth - imageWidth) {
			x = frameWidth - imageWidth;
		}
		if (y > frameHeight - imageHeight) {
			y = frameHeight - imageHeight;
		}
		
		collision();
	}
	
	public void collision() {
		for (int i = 0; i < enemies.size(); i++) {
			if (getBounds().intersects(enemies.get(i).getBounds())) {
				System.out.println("Collision");
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key) {
			case KeyEvent.VK_RIGHT:
				velX = 5;
				break;
			case KeyEvent.VK_LEFT:
				velX = -5;
				break;
			case KeyEvent.VK_UP:
				velY = -5;
				break;
			case KeyEvent.VK_DOWN:
				velY = 5;
				break;
			default:
				break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key) {
			case KeyEvent.VK_RIGHT:
				velX = 0;
				break;
			case KeyEvent.VK_LEFT:
				velX = 0;
				break;
			case KeyEvent.VK_UP:
				velY = 0;
				break;
			case KeyEvent.VK_DOWN:
				velY = 0;
				break;
			default:
				break;
		}		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImage(), x, y, null);
	}
	
	public Image getPlayerImage() {
		ImageIcon icon = new ImageIcon(getClass().getResource(playerImage));
		return icon.getImage();
	}

}
