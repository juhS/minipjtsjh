package dongyub;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PlayerLabel extends JLabel{

	Image icon =  new ImageIcon("src/miniproject/images/camera/char.gif").getImage().getScaledInstance(100, 100, 0);
	
	public PlayerLabel() {
		
		//icon =  new ImageIcon("dispatch_images/chracter/character.png").getImage().getScaledInstance(100, 100, 0);
		this.setLocation(440, 440);
		this.setSize(100, 100);
		this.setIcon(new ImageIcon(icon));
		
		//배고파상진
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
