package miniproject.views;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Timer extends Thread{

	private JPanel panel;

	public Timer(JPanel panel){
		this.panel = panel;
	}

	@Override
	public void run() {
		JTextField label = new JTextField("남은시간 : ");
		label.setBounds(100, 380, 300, 100);
		label.setFont(new Font("Sanscerif", Font.BOLD, 40));
		panel.add(label);
		for(int i = 60; i >= 0; i--){
			try {
				System.out.println(i);
				this.sleep(1000);
				label.setText("  남은시간 : " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}


