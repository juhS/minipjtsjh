package miniproject.views.mainMap;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.jungukGame.MainPage;
import miniproject.views.minipublic.Sosok_01;
import miniproject.views.trotGame.FirstPanel;

public class MyKeyListenerJunGuk extends KeyAdapter{

	private MainFrame mf;
	private JPanel panel;
	private JLabel la;
	private Player123 player;
	private static final int MOVE_UNIT = 10;

	public MyKeyListenerJunGuk(JLabel la, MainFrame mf, JPanel panel, Player123 player) {
		this.la = la;
		this.mf = mf;
		this.panel = panel;
		this.player = player;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int a = la.getX();
		int b = la.getY();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		int a = la.getX();
		int b = la.getY();
		if(player.getDanceScore() == 1 && player.getSingScore() == 1) {
			if((a >= 800 && a <= 900)&&(b >= -50 && b <= 0)) {
				ChangePanel.changePanel(mf, panel, new MainPage(mf,player));
				mf.revalidate();
			}
		}
		if(player.getDanceScore() == 2 && player.getSingScore() == 2) {
			if((a >= 250 && a <= 350) && (b >= 500 && b <= 580)) {
				ChangePanel.changePanel(mf, panel, new FirstPanel(mf,player));
				mf.revalidate();
			}
		}
		if(player.getDanceScore() == 0 && player.getSingScore() == 0) {
			if((a >= 550 && a <= 700)&&(b >= 400 && b <= 460)) {
				ChangePanel.changePanel(mf, panel, new Sosok_01(mf, player));
				mf.revalidate();
			}
		}

		switch(keyCode) {
		case KeyEvent.VK_UP:
			if(b >= 0) {
				la.setLocation(la.getX(), la.getY() - MOVE_UNIT);
			}
			break;
		case KeyEvent.VK_DOWN:
			if(b <= 790) {
				la.setLocation(la.getX(), la.getY() + MOVE_UNIT);
			}
			break;
		case KeyEvent.VK_LEFT:
			if(a >= 10) {
				la.setLocation(la.getX() - MOVE_UNIT, la.getY());
			}
			break;
		case KeyEvent.VK_RIGHT :
			if(a <= 1300) {
				la.setLocation(la.getX() + MOVE_UNIT, la.getY());
			}
			break;
		case KeyEvent.VK_SPACE:
			System.out.println(la.getX());
			System.out.println(la.getY());
		}
	}

}
