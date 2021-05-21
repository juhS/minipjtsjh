package miniproject.views.trotGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.minipublic.Sosok_01_trot;

public class TrotGame extends JPanel{
	
	private Player123 player;

	private Image off = new ImageIcon("src/miniproject/images/camera/image_0.png").getImage().getScaledInstance(400, 250,java.awt.Image.SCALE_SMOOTH);
	private Image on = new ImageIcon("src/miniproject/images/camera/image_1.png").getImage().getScaledInstance(400, 250, java.awt.Image.SCALE_SMOOTH);
	private Image back = new ImageIcon("src/miniproject/images/camera/background.jpeg").getImage().getScaledInstance(1400, 900, java.awt.Image.SCALE_SMOOTH);
	private Image talk = new ImageIcon("src/miniproject/images/ssing/talkframe.png").getImage().getScaledInstance(800, 400,java.awt.Image.SCALE_SMOOTH );
	private Image startB = new ImageIcon("src/miniproject/images/camera/startBtn.png").getImage().getScaledInstance(100, 50,java.awt.Image.SCALE_SMOOTH);

	private MainFrame mf;
	private JPanel panel;
	private JLabel[] cameraoff = new JLabel[9];

	private int score = 0 ;
	private int timeLeft = 30;
	private String  con = "ON";
	private String  coff = "OFF";

	private JLabel lbScore;
	private JLabel lbTimeLeft;
	private JLabel lbCount;
	private JLabel totalScore;
	private JTextField printText;

	private JButton btnStart;
	private Timer timer;

	private boolean programStart = false;
	
	

	public TrotGame(MainFrame mf, Player123 player) {
		this.mf = mf;
		panel = this;
		this.player = player;
		
		System.out.println(player.getUserId());
		
		initGUI();
		addC();
		initEvents();

	}
	
	

	private void initGUI() {

		this.setLayout(null);

		lbScore = new JLabel("점수 : 0");
		lbScore.setHorizontalAlignment(SwingConstants.TRAILING);
		lbScore.setForeground(Color.WHITE);
		lbScore.setFont(new Font("휴먼엑스포", Font.BOLD, 30));
		lbScore.setBounds(400,20,300,200);
		panel.add(lbScore);
		
		totalScore = new JLabel();
		totalScore.setIcon(new ImageIcon(talk));
		totalScore.setLayout(null);
		totalScore.setBounds(300,0,1000,1000);
		totalScore.setVisible(false);
		panel.add(totalScore);

		lbTimeLeft = new JLabel("시간 : ");
		lbTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lbTimeLeft.setFont(new Font("휴먼엑스포", Font.BOLD, 30));
		lbTimeLeft.setForeground(Color.WHITE);
		lbTimeLeft.setBounds(100,20,250,200);
		panel.add(lbTimeLeft);
		
		
		lbCount = new JLabel();
		lbCount.setFont(new Font("휴먼엑스포", Font.BOLD, 400));
		lbCount.setForeground(Color.white);
		lbCount.setBounds(600,100,600,600);
		panel.add(lbCount);
		

		btnStart = new JButton();
		btnStart.setBounds(1100,60,110,33);
		btnStart.setBorderPainted(false);
		btnStart.setContentAreaFilled(false);
		btnStart.setFocusPainted(false);
		btnStart.setIcon(new ImageIcon(startB));
		panel.add(btnStart);
		
	}

	
	
	private void addC() {
		cameraoff[0] = new JLabel(coff);
		cameraoff[0].setName(coff);
		cameraoff[0].setIcon(new ImageIcon(off));
		cameraoff[0].setBounds(50, 150, 400, 250);
		panel.add(cameraoff[0]);

		cameraoff[1] = new JLabel(coff);
		cameraoff[1].setName(coff);
		cameraoff[1].setIcon(new ImageIcon(off));
		cameraoff[1].setBounds(470, 150, 400, 250);
		panel.add(cameraoff[1]);

		cameraoff[2] = new JLabel(coff);
		cameraoff[2].setName(coff);
		cameraoff[2].setIcon(new ImageIcon(off));
		cameraoff[2].setBounds(900, 150, 400, 250);
		panel.add(cameraoff[2]);

		cameraoff[3] = new JLabel(coff);
		cameraoff[3].setName(coff);
		cameraoff[3].setIcon(new ImageIcon(off));
		cameraoff[3].setBounds(50, 370, 400, 250);
		panel.add(cameraoff[3]);

		cameraoff[4] = new JLabel(coff);
		cameraoff[4].setName(coff);
		cameraoff[4].setIcon(new ImageIcon(off));
		cameraoff[4].setBounds(470, 370, 400, 250);
		panel.add(cameraoff[4]);

		cameraoff[5] = new JLabel(coff);
		cameraoff[5].setName(coff);
		cameraoff[5].setIcon(new ImageIcon(off));
		cameraoff[5].setBounds(900, 370, 400, 250);
		panel.add(cameraoff[5]);


		cameraoff[6] = new JLabel(coff);
		cameraoff[6].setName(coff);
		cameraoff[6].setIcon(new ImageIcon(off));
		cameraoff[6].setBounds(50, 600, 400, 250);
		panel.add(cameraoff[6]);


		cameraoff[7] = new JLabel(coff);
		cameraoff[7].setName(coff);
		cameraoff[7].setIcon(new ImageIcon(off));
		cameraoff[7].setBounds(470, 600, 400, 250);
		panel.add(cameraoff[7]);


		cameraoff[8] = new JLabel(coff);
		cameraoff[8].setName(coff);
		cameraoff[8].setIcon(new ImageIcon(off));
		cameraoff[8].setBounds(900, 600, 400, 250);
		panel.add(cameraoff[8]);


	}

	
	

	private void initEvents() {

		for(int i = 0; i < cameraoff.length; i++) {
			cameraoff[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JLabel lbl = (JLabel) e.getSource();
					String id = lbl.getText();
					pressedButton(id,lbl);			
				}
			});
		}

		
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnStart.setEnabled(false);
				timer.start();
				for(int i = 0; i < cameraoff.length;i++) {
					new Thread(new DThread(i)).start();
				}
			}
		});

		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(timeLeft == 0) {
					lbTimeLeft.setText("남은시간  : ");
					timer.stop();
					programStart = true;
					offAll();
					totalScore.setVisible(true);
					player.setTotalScore(player.getTotalScore() + score);
					printText = new JTextField(score + "점을 획득하셨습니다.") {
						@Override
						public void setBorder(Border boder) {
							
						}
					};
					printText.setFont(new Font("휴먼엑스포", Font.BOLD, 50));
					printText.setForeground(Color.BLACK);
					printText.setBounds(80,400,700,200);
					printText.addMouseListener(new MouseAdapter() {
						
						
						@Override
						public void mouseClicked(MouseEvent e) {
							ChangePanel.changePanel(mf, panel, new Sosok_01_trot(mf,player));
							mf.revalidate();
						}
					});
					totalScore.add(printText);

				}
				lbTimeLeft.setText("남은시간 : " + timeLeft);
				timeLeft--;

			}
		});
	}


	
	

	private void pressedButton(String id, JLabel lbl) {
		String val = id;
		System.out.println(id);
		if(!(programStart)) {
			if("ON".equals(val)) {
				score += 5;
				lbScore.setText("점수 : " + score);
				lbl.setIcon(new ImageIcon(off));
				lbl.setText(coff);
				repaint();
			}else if("OFF".equals(val)){
				if(score <= 0) {
					score = 0;
					lbScore.setText("점수 : " + score);
				} else {
					score -= 5;
				}
			}
		}
		lbScore.setText("점수 : " + score);
	}

	

	private void offAll() {
		if(programStart) {
			for(int i = 0; i < cameraoff.length; i++) {
				cameraoff[i].setIcon(new ImageIcon(off));
				cameraoff[i].setText(coff);
				repaint();
				
			}
		}
	}

	
	
	public class DThread implements Runnable{
		int index = 0; //두더지번호

		public DThread(int index) {
			this.index = index;
		}
		
		

		@Override
		public void run() {
			while(!(programStart)) {
				try {
					int offtime = new Random().nextInt(8000) + 1000;
					Thread.sleep(offtime);
					
					if(!(programStart)) {
						onHandler(index);
						
					}



					Thread.sleep(3000);
					if(!(programStart)) {
						offHandler(index);
					}
					

				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
	private void onHandler(int index) {
		cameraoff[index].setIcon(new ImageIcon(on));
		cameraoff[index].setText(con);
		repaint();
	}
	
	private void offHandler(int index) {
		cameraoff[index].setIcon(new ImageIcon(off));
		cameraoff[index].setText(coff);
		repaint();
	}
	
	
	
//	private void saveHighscore() {
//		BufferedWriter bw = null;
//		try {
//			bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"/highscore.txt", false));
//			bw.write(""+score);
//			bw.flush();
//			bw.close();
//		}catch(Exception e) {
//			JOptionPane.showMessageDialog(this, e.getMessage(), "Error while saving hiasda sd", JOptionPane.ERROR_MESSAGE);
//		}
//	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(back,0, 0, 	1400, 900,null);
		setOpaque(false);
		mf.repaint();
	}

}