package com.coltla.src;

import javax.swing.JFrame;

public class MainClass {

	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
		
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		frame.pack();
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Beginner Game");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Game(WIDTH, HEIGHT));
		frame.setVisible(true);
	}
}
