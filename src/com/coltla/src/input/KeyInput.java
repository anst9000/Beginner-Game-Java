package com.coltla.src.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.coltla.src.objects.Player;

public class KeyInput extends KeyAdapter {

	private Player player;
	
	public KeyInput(Player player) {
		this.player = player;
	}
	
	public void keyPressed(KeyEvent e) {
		player.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		player.keyReleased(e);		
	}
}
