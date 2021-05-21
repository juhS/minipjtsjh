package miniproject.views.mainMap;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.dispatch_game.DispatchPanel;

public class MyKeyListenerDispatch extends KeyAdapter{

	private MainFrame mf;
	private JLabel la;
	private JPanel panel;
	private Player123 player;
	private static final int MOVE_UNIT = 10;
	
	public MyKeyListenerDispatch(JLabel la, MainFrame mf, JPanel panel, Player123 player) {
		this.mf = mf;
		this.la = la;
		this.panel = panel;
		this.player = player;
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if((la.getX() >= 780 && la.getX() <= 900) && (la.getY() >= 260 && la.getY() <= 520)) {
			ChangePanel.changePanel(mf, panel, new DispatchPanel(mf, player));
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		int a = la.getX();
		int b = la.getY();
		
		switch(keyCode){
		
		case KeyEvent.VK_UP :
			if(b >= 0) {
			la.setLocation(la.getX(), la.getY() - MOVE_UNIT);
			}
			break;
		case KeyEvent.VK_DOWN :
			if(b <= 790) {
			la.setLocation(la.getX(), la.getY() + MOVE_UNIT);
			}
			break;
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
