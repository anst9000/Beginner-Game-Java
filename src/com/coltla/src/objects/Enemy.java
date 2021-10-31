package com.coltla.src.objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import com.coltla.src.GlobalPosition;
import com.coltla.src.MainClass;

public class Enemy extends GlobalPosition {

	private String enemyImage = "/images/enemy.png";
	int speed;
	Random rand = new Random();

	public Enemy(int x, int y) {
		super(x, y);
		
		speed = rand.nextInt(6) + 1;
	}
	
	public void update() {
		x += speed;

		if (x > MainClass.WIDTH - 32) {
			speed = -speed;
		}
		if (x < -2) {
			speed = -speed;
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(getEnemyImage(), x, y, null);
	}
	
	public Image getEnemyImage() {
		ImageIcon icon = new ImageIcon(getClass().getResource(enemyImage));
		return icon.getImage();
	}

}
