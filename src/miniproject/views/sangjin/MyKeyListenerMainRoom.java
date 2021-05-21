package miniproject.views.sangjin;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.mainMap.MainMapFirst;
import miniproject.views.mainMap.MainMapdispatch;

public class MyKeyListenerMainRoom extends KeyAdapter{

	private MainFrame mf;
	private JPanel panel;
	private static final int MOVE_UNIT = 10;
	private JLabel la;
	private Player123 player;

	public MyKeyListenerMainRoom(JLabel la, MainFrame mf, JPanel panel, Player123 player) {
		this.la = la;
		this.mf = mf;
		this.panel = panel;
		this.player = player;
	}

	public void keyReleased(KeyEvent e) {
		if((la.getX() >= 560 && la.getX() <= 690)&&(la.getY() >= 500 && la.getY() <= 540)) {
			ChangePanel.changePanel(mf, panel, new MainMapFirst(mf,player));
//			ChangePanel.changePanel(mf, panel, new MainMapdispatch(mf,player));
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
			if(b >= 150) {
			la.setLocation(la.getX(),la.getY()-MOVE_UNIT);
			}
			break;
		case KeyEvent.VK_DOWN :
			if(b <= 500) {
			la.setLocation(la.getX(), la.getY() + MOVE_UNIT);
			}
			break;
		case KeyEvent.VK_LEFT :
			if(a >= 320) {
			la.setLocation(la.getX() - MOVE_UNIT, la.getY());
			}
			break;
		case KeyEvent.VK_RIGHT :
			if(a <= 920) {
			la.setLocation(la.getX() + MOVE_UNIT, la.getY());
			}
			break;
		}
	}

}
