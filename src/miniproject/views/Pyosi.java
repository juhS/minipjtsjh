package miniproject.views;

import java.awt.Graphics;

import javax.swing.JLabel;

import miniproject.model.vo.Player123;

public class Pyosi extends JLabel{

	private Player123 player;
	private String str = "";
	public Pyosi(Player123 player) {

		this.player = player;
		this.str = str;
		this.setLocation(1000,100);
		this.setSize(700,700);

	}

	public void paintComponent(Graphics g) {
		String str = "닉넴 : " + player.getUserId() +" "+ "춤 : "+player.getDanceScore() 
		+" "+ "노래 : "+player.getSingScore() 
		+" " +" " + " 총점 : " + player.getTotalScore() ;
		g.drawString(str,0 ,30);
		super.paintComponent(g);

	}	

}
