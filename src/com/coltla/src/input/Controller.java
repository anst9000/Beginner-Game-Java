package com.coltla.src.input;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

import com.coltla.src.objects.Enemy;

public class Controller {

	static LinkedList<Enemy> enemies = new LinkedList<>();
	Enemy tempEnemy;
	
	public Controller(int amount) {
		Random rand = new Random();

		for (int i = 0; i < amount; i++) {
			addEnemy(new Enemy(rand.nextInt(600), rand.nextInt(440)));
		}
	}
	
	public void draw(Graphics2D g2d) {
		for (int i = 0; i < enemies.size(); i++) {
			tempEnemy = enemies.get(i);
			tempEnemy.draw(g2d);
		}
	}
	
	public void update() {
		for (int i = 0; i < enemies.size(); i++) {
			tempEnemy = enemies.get(i);
			tempEnemy.update();
		}
	}
	
	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
	}
	
	public void removeEnemy(Enemy enemy) {
		enemies.remove(enemy);
	}
	
	public static LinkedList<Enemy> getEnemies() {
		return enemies;
	}
}
