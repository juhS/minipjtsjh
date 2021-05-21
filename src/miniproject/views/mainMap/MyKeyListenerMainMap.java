package miniproject.views.mainMap;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.sangjin.MainRoom;
import miniproject.views.somang.Park;

public class MyKeyListenerMainMap extends KeyAdapter{
	
	private MainFrame mf;
	private JLabel la;
	private JPanel panel;
	private Player123 player;
	private static final int MOVE_UNIT = 10;
	
	public MyKeyListenerMainMap(JLabel la, MainFrame mf, JPanel panel, Player123 player) {
		this.mf = mf;
		this.la =  la;
		this.panel = panel;
		this.player = player;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int a = la.getX();
		int b = la.getY();
		if((a >= 455 && a <= 755)&& (b >=110 && b <= 170)) {
			ChangePanel.changePanel(mf, panel, new Park(mf, player));
			mf.revalidate();
		}
		if((a >= 1000 && a <= 1100)&&(b >= 400 && b <= 470)) {
			ChangePanel.changePanel(mf, panel, new MainRoom(mf, player));
			mf.revalidate();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		int a = la.getX();
		int b = la.getY();
		
		switch(keyCode) {
		
		case KeyEvent.VK_UP :
			if(b >= 0) {
				la.setLocation(la.getX(),la.getY() - MOVE_UNIT);
			}
			break;
		case KeyEvent.VK_DOWN :
			if(b <= 790) {
				la.setLocation(la.getX(), la.getY() + MOVE_UNIT);
			}
			break;
		case KeyEvent.VK_LEFT :
			if(a >= 10) {
				la.setLocation(la.getX() - MOVE_UNIT, la.getY());
			}
			break;
		case KeyEvent.VK_RIGHT :
			if(a <= 1300) {
				la.setLocation(la.getX() + MOVE_UNIT, la.getY());
			}
			break;
		case KeyEvent.VK_SPACE :
			System.out.println(la.getX());
			System.out.println(la.getY());
			
		}
	}
	
	
	
	
	
	
	

}
