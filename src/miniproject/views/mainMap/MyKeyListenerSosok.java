package miniproject.views.mainMap;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.minipublic.Sosok_01;
import miniproject.views.trotGame.FirstPanel;

public class MyKeyListenerSosok extends KeyAdapter{

	private MainFrame mf;
	private JPanel panel;
	private static final int MOVE_UNIT = 10;
	private JLabel la;
	private Player123 player;
	
	public MyKeyListenerSosok(JLabel la, MainFrame mf, JPanel panel, Player123 player) {
		this.la = la;
		this.mf = mf;
		this.panel = panel;
		this.player = player;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int a = la.getX();
		int b = la.getY();
		if((a >= 550 && a <= 700)&&(b >= 400 && b <= 460)) {
			ChangePanel.changePanel(mf, panel, new Sosok_01(mf, player));
			mf.revalidate();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		int a = la.getX();
		int b = la.getY();
		
		switch(keyCode) {
		case KeyEvent.VK_UP:
			if(b >= 0) {
			la.setLocation(la.getX(), la.getY() - MOVE_UNIT);
			}
			break;
		case KeyEvent.VK_DOWN :
			if(b <= 790) {
			la.setLocation(la.getX(), la.getY() + MOVE_UNIT);
			break;
			}
		case KeyEvent.VK_LEFT:
			if(a >= 10) {
			la.setLocation(la.getX() - MOVE_UNIT, la.getY());
			}
			break;
		case KeyEvent.VK_RIGHT:
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
