package miniproject.views.firstPage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.nickname.NickName;

import javax.swing.JFrame;
public class FirstPage extends JPanel {
	
	private MainFrame mf;
	private FirstPage fp = this;
	
	public void paintComponent(Graphics g) {	
		ImageIcon  firstPage= new ImageIcon("src/miniproject/images/FirstPage/first.gif");
		g.drawImage(firstPage.getImage(), 0, 0, 1400, 900, null);
		setOpaque(false); 
		super.paintComponent(g);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mf.repaint();
		
	}
	
	public FirstPage(MainFrame mf) {
		this.mf =mf;
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, fp, new NickName(mf));
				
			}

			
			
		});
		
	}
	
}	
	