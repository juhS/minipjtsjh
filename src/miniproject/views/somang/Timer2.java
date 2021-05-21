package miniproject.views.somang;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;

public class Timer2 extends Thread{
	private  MainFrame mf;
	private JPanel panel;
	private boolean isStop = false;
	MouseEvent e;
	
	private Player123 player;
	private int jum;
	
	public Timer2() {
		
	}
	
	public Timer2(MainFrame mf, JPanel panel) {
		this.mf= mf;
		this.panel =panel;
	}
	
	

	@Override
	public void run() {
		int i  = 20;
		JTextField label = new JTextField();
		label.setBounds(0,0,150,50);
		label.setFont(new Font("Sanscerif",Font.BOLD,20));
		panel.add(label);
		while(i >= 0 && !Thread.currentThread().isInterrupted()) {	
			try {
				System.out.println(i);
				this.sleep(1000);
				label.setText("제한시간 : " + i);
			}catch(InterruptedException e) {
				
			}
			i--;
		}
		ssingNext_lose();
		
		System.out.println("종료");

		
	}//--run 
	
	public void ssingNext_lose() {
		// 통과이면(cnt 2이상이고 3이되면) 노래점수+1
		// 타이머 stop하고 다음 화면 넘어가기
		MiniGameSsing_lose gp = new MiniGameSsing_lose(mf,player,jum);
		ChangePanel.changePanel(mf, panel, gp);
		this.stop();
	}
	
	
	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}
	
	public class Test1{
		
		public void process() {
			Timer2 t2 = new Timer2();
			Thread thread = new Thread(t2);
			thread.start();
			try {
				Thread.sleep(2000);
			}catch(Exception e) {
				e.printStackTrace();
			}
			t2.interrupt();
		}
	}
	
	
}