package com.coltla.src;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.coltla.src.input.Controller;
import com.coltla.src.input.KeyInput;
import com.coltla.src.objects.Enemy;
import com.coltla.src.objects.Player;

public class Game extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private String backgroundImage = "/images/background.png";
	
	private Timer gameloop;
	private Player player;
	private Controller controller;

	public Game(int frameWidth, int frameHeight) {
		setFocusable(true);
		
		gameloop = new Timer(10, this);
		gameloop.start();
		
		player = new Player(100, 100);
		controller = new Controller(5);
	
		addKeyListener(new KeyInput(player));
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(getBackgroundImage(), 0, 0, this);
		player.draw(g2d);
		controller.draw(g2d);
	}
	
	public Image getBackgroundImage() {
		ImageIcon icon = new ImageIcon(getClass().getResource(backgroundImage));
		return icon.getImage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		player.update();
		controller.update();
	}
}
