package miniproject.views.somang;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;

public class MiniGameSsing2 extends JPanel {
	private MainFrame mf;
	private JPanel panel;
	private ImageIcon icon;
	private ImageIcon talk;
	private ImageIcon charac01;
	private ImageIcon sTest;

	private JTextField input;
	private JTextField input2;
	private JTextField input3;
	
	private Player123 player;
	
	String one = "";
	String two = "";
	String three = "";
	
	public MiniGameSsing2(MainFrame mf, Player123 player) {
		
		this.mf = mf;
		panel = this;
		this.player = player;
		
		this.setLayout(null);
		icon = new ImageIcon("src/miniproject/images/ssing/sosokSing.png");
		talk = new ImageIcon("src/miniproject/images/ssing/talkframe.png");
		charac01 = new ImageIcon("src/miniproject/images/ssing/Characters02.gif");

		

		// 텍스트입력
		JLabel label = new JLabel("빈칸에 들어갈 말은? : ");
		label.setFont(new Font("Neo둥근모", Font.PLAIN, 25));
		label.setBounds(70, 740, 250, 50);
		panel.add(label);

		input = new JTextField();
		input2 = new JTextField();
		input3 = new JTextField();

		input.setFont(new Font("Neo둥근모", Font.BOLD, 30));
		input.setBounds(300, 740, 100, 50);

		input2.setFont(new Font("Neo둥근모", Font.BOLD, 30));
		input2.setBounds(410, 740, 100, 50);

		input3.setFont(new Font("Neo둥근모", Font.BOLD, 30));
		input3.setBounds(520, 740, 100, 50);

		panel.add(input);
		panel.add(input2);
		panel.add(input3);

		Timer2 timer = new Timer2(mf,this);
		 Thread t1 = timer;
		 t1.start();
			
		MiniGameSsing_test st = new MiniGameSsing_test(mf, panel, num, input, input2, input3,player);

		//3번째에서만 엔터 이벤트 발생  -> 전체 입력시 한번에 검토후 넘어가기
		input3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				one = input.getText();
				System.out.println(one);

				two = input2.getText();
				System.out.println(two);

				three = input3.getText();
				System.out.println(three);
				
				String[] inputArr = {one, two, three};
				
				st.StestPass(inputArr);
				t1.stop();
			}

		});
		
		

	}

	int num = (int) (Math.random() * 10) + 1;
	ImageIcon test = new ImageIcon("src/miniproject/images/ssing/sTest_" + num + ".png");
	

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// 배경이미지
		g.drawImage(icon.getImage(), 0, 0, null);
		// 대화창이미지
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);
		// 캐릭터 이미지
		if (charac01 != null) {
			g.drawImage(charac01.getImage(), 50, 200, 398, 398, this);
		}
		// 테스트 이미지

		sTest = test; // 이미지 1
		g.drawImage(sTest.getImage(), 500, 180, 772, 408, null); // 이미지1
		g.setFont(new Font("Neo둥근모", Font.BOLD, 36));
		g.drawString("빈칸에 알맞은 노래가사를 적자! 엔터를 누르지 않으면 무효! \n", 70, 720);
		
		setOpaque(false);

	}
	
	
	
}