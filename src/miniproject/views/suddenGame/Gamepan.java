package miniproject.views.suddenGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.ending.EndingBackSudden;
import miniproject.views.mainMap.MainMapdispatch;

public class Gamepan extends JPanel {
	private int x1 = 0;
	private int y1 = 0;
	private int x2 = 0;
	private int y2 = 0;
	private int clicks = 0;
	private int num = 0;
	
	private MainFrame mf;
	private Player123 player;
	private int score = 150;
	
	Timer timer;
	private int t = 60;
	
	private Set set1 = new LinkedHashSet();
	private Set set2 =  new LinkedHashSet();
	
	private JPanel panel;
	private JButton [] btns = new JButton[9];
	private JLabel [] ans = new JLabel[9];
	private int [] locs = new int [3];
	public void paintComponent(Graphics g) {
		
		ImageIcon bground = new ImageIcon("src/miniproject/images/suddenGame/bground_0.jpg");
		g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
		setOpaque(false); 
		super.paintComponent(g);
		mf.revalidate();
	}
	

	public Gamepan(MainFrame mf,  Player123 player) {
		this.setSize(1400,900);
		this.setLayout(null);
		this.mf = mf;
		this.player = player;
		this.panel = this;
		

		Image no1 = new ImageIcon("src/miniproject/images/suddenGame/1.jpg").getImage().getScaledInstance(150, 150, 0);
		Image no2 = new ImageIcon("src/miniproject/images/suddenGame/2.jpg").getImage().getScaledInstance(150, 150, 0);
		Image no3 = new ImageIcon("src/miniproject/images/suddenGame/3.jpg").getImage().getScaledInstance(150, 150, 0);
		Image no4 = new ImageIcon("src/miniproject/images/suddenGame/4.jpg").getImage().getScaledInstance(150, 150, 0);
		Image no5 = new ImageIcon("src/miniproject/images/suddenGame/5.jpg").getImage().getScaledInstance(150, 150, 0);
		Image no6 = new ImageIcon("src/miniproject/images/suddenGame/6.jpg").getImage().getScaledInstance(150, 150, 0);
		Image no7 = new ImageIcon("src/miniproject/images/suddenGame/7.jpg").getImage().getScaledInstance(150, 150, 0);
		Image no8 = new ImageIcon("src/miniproject/images/suddenGame/8.jpg").getImage().getScaledInstance(150, 150, 0);
		Image no9 = new ImageIcon("src/miniproject/images/suddenGame/9.jpg").getImage().getScaledInstance(150, 150, 0);

		btns[0] = new JButton(new ImageIcon(no1));
		btns[1] = new JButton(new ImageIcon(no2)); 
		btns[2] = new JButton(new ImageIcon(no3)); 
		btns[3] = new JButton(new ImageIcon(no4)); 
		btns[4] = new JButton(new ImageIcon(no5)); 
		btns[5] = new JButton(new ImageIcon(no6)); 
		btns[6] = new JButton(new ImageIcon(no7)); 
		btns[7] = new JButton(new ImageIcon(no8)); 
		btns[8] = new JButton(new ImageIcon(no9)); 
		
		for (int i = 0; i < ans.length; i++) {
			ans[i]= new JLabel();
			ans[i].setSize(150, 150);
			ans[i].setName(Integer.valueOf(i).toString());
		}
	
				

		for (int i = 0; i < btns.length; i++) {
			btns[i].setSize(150, 150);
			btns[i].setName(Integer.valueOf(i).toString());
			this.add(ans[i]);
		}

		int loca1 = 20;
		int loca2 = 175;
		int loca3 = 330;


		Integer num1 = loca1;
		Integer num2 = loca2;
		Integer num3 = loca3;

		locs[0]= num1;
		locs[1]=num2;
		locs[2]=num3;

		System.out.println("while문 시작");

		while ((set1.size() <4) && (set2.size() <4)) {
			set1.add( locs[(int)(Math.random()*3)]);
			System.out.println(set1);
			set2.add( locs[(int)(Math.random()*3)]);
			System.out.println(set2);
			if ((set1.size() ==3) && (set2.size() ==3)) {
				break;
			}
		}
		System.out.println("while문 끝남");

		Object[] obj1 = set1.toArray(); 
		Object[] obj2 = set2.toArray();
		//랜덤으로 그림 배치
		btns[0].setLocation((int)obj1[0],(int)obj2[0]);
		btns[1].setLocation((int)obj1[0],(int)obj2[1]);
		btns[2].setLocation((int)obj1[0],(int)obj2[2]);
		btns[3].setLocation((int)obj1[1],(int)obj2[0]);
		btns[4].setLocation((int)obj1[1],(int)obj2[1]);
		btns[5].setLocation((int)obj1[1],(int)obj2[2]);
		btns[6].setLocation((int)obj1[2],(int)obj2[0]);
		btns[7].setLocation((int)obj1[2],(int)obj2[1]);
		btns[8].setLocation((int)obj1[2],(int)obj2[2]);
		
		//정답 라벨 배치
		
		ans[0].setLocation(loca1,loca1);
		ans[1].setLocation(loca1,loca2);
		ans[2].setLocation(loca1,loca3);
		ans[3].setLocation(loca2,loca1);
		ans[4].setLocation(loca2,loca2);
		ans[5].setLocation(loca2,loca3);
		ans[6].setLocation(loca3,loca1);
		ans[7].setLocation(loca3,loca2);
		ans[8].setLocation(loca3,loca3);
		
		int answer [] = {loca1,loca1,loca2,loca1,loca3,loca1,loca1,loca2,loca2,loca2,loca3,loca2,loca1,loca3,loca2,loca3,
				loca3,loca3};
		int submit [] = new int[18];
		
		

		this.setOpaque(false);

		for (int i = 0; i < btns.length; i++) {
			this.add(btns[i]);
		}


		btns[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(CheckAnswer.checkAnswer(submit,answer)==false) {

					if (clicks ==0) {
						num = 0;
						x1 = btns[num].getX();
						y1 = btns[num].getY();
						btns[num].setVisible(false);
						btns[num].setLayout(null);
						panel.repaint();
						clicks += 1;	
					}
					else if (clicks ==1 && btns[num] != btns[0]) {
						x2=btns[0].getX();
						y2=btns[0].getY();
						btns[num].setLocation(x2,y2);
						btns[num].setVisible(true);
						btns[0].setLayout(null);
						btns[0].setLocation(x1,y1);
						btns[0].setVisible(true);
						panel.repaint();
						clicks -= 1;	
					}
					
					for ( int i = 0; i < (submit.length/2); i++) {
						submit[i*2] = btns[i].getX();
						submit[(i*2)+1] = btns[i].getY();
					}
					System.out.println("btn0위치: " + btns[0].getX()+ ","+ btns[1].getY());
					System.out.println("btn1위치: " + btns[1].getX()+ ","+ btns[1].getY());
					System.out.println("btn2위치: " + btns[2].getX()+ ","+ btns[2].getY());
					System.out.println("btn3위치: " + btns[3].getX()+ ","+ btns[3].getY());
					System.out.println("btn4위치: " + btns[4].getX()+ ","+ btns[4].getY());
					System.out.println("btn5위치: " + btns[5].getX()+ ","+ btns[5].getY());
					System.out.println("btn6위치: " + btns[6].getX()+ ","+ btns[6].getY());
					System.out.println("btn7위치: " + btns[7].getX()+ ","+ btns[7].getY());
					System.out.println("btn8위치: " + btns[8].getX()+ ","+ btns[8].getY());
					System.out.println(Arrays.toString(submit));
					System.out.println(Arrays.toString(answer));


				}
				panel.repaint();
				}		
		});

		btns[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(CheckAnswer.checkAnswer(submit,answer)==false) {

					if (clicks ==0) {
						num = 1;
						x1 = btns[num].getX();
						y1 = btns[num].getY();
						btns[num].setVisible(false);
						btns[num].setLayout(null);
						panel.repaint();
						clicks += 1;	
					}
					else if (clicks ==1 && btns[num] != btns[1]) {
						x2=btns[1].getX();
						y2=btns[1].getY();
						btns[num].setLocation(x2,y2);
						btns[num].setVisible(true);
						btns[1].setLayout(null);
						btns[1].setLocation(x1,y1);
						btns[1].setVisible(true);
						panel.repaint();
						clicks -= 1;	
					}
					
					for ( int i = 0; i < (submit.length/2); i++) {
						submit[i*2] = btns[i].getX();
						submit[(i*2)+1] = btns[i].getY();
					}
					System.out.println("btn0위치: " + btns[0].getX()+ ","+ btns[1].getY());
					System.out.println("btn1위치: " + btns[1].getX()+ ","+ btns[1].getY());
					System.out.println("btn2위치: " + btns[2].getX()+ ","+ btns[2].getY());
					System.out.println("btn3위치: " + btns[3].getX()+ ","+ btns[3].getY());
					System.out.println("btn4위치: " + btns[4].getX()+ ","+ btns[4].getY());
					System.out.println("btn5위치: " + btns[5].getX()+ ","+ btns[5].getY());
					System.out.println("btn6위치: " + btns[6].getX()+ ","+ btns[6].getY());
					System.out.println("btn7위치: " + btns[7].getX()+ ","+ btns[7].getY());
					System.out.println("btn8위치: " + btns[8].getX()+ ","+ btns[8].getY());
					System.out.println(Arrays.toString(submit));
					System.out.println(Arrays.toString(answer));


				}
				panel.repaint();
				}		
		});

		btns[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(CheckAnswer.checkAnswer(submit,answer)==false) {

					if (clicks ==0) {
						num = 2;
						x1 = btns[num].getX();
						y1 = btns[num].getY();
						btns[num].setVisible(false);
						btns[num].setLayout(null);
						panel.repaint();
						clicks += 1;	
					}
					else if (clicks ==1 && btns[num] != btns[2]) {
						x2=btns[2].getX();
						y2=btns[2].getY();
						btns[num].setLocation(x2,y2);
						btns[num].setVisible(true);
						btns[2].setLayout(null);
						btns[2].setLocation(x1,y1);
						btns[2].setVisible(true);
						panel.repaint();
						clicks -= 1;	
					}
					
					for ( int i = 0; i < (submit.length/2); i++) {
						submit[i*2] = btns[i].getX();
						submit[(i*2)+1] = btns[i].getY();
					}
					System.out.println("btn0위치: " + btns[0].getX()+ ","+ btns[1].getY());
					System.out.println("btn1위치: " + btns[1].getX()+ ","+ btns[1].getY());
					System.out.println("btn2위치: " + btns[2].getX()+ ","+ btns[2].getY());
					System.out.println("btn3위치: " + btns[3].getX()+ ","+ btns[3].getY());
					System.out.println("btn4위치: " + btns[4].getX()+ ","+ btns[4].getY());
					System.out.println("btn5위치: " + btns[5].getX()+ ","+ btns[5].getY());
					System.out.println("btn6위치: " + btns[6].getX()+ ","+ btns[6].getY());
					System.out.println("btn7위치: " + btns[7].getX()+ ","+ btns[7].getY());
					System.out.println("btn8위치: " + btns[8].getX()+ ","+ btns[8].getY());
					System.out.println(Arrays.toString(submit));
					System.out.println(Arrays.toString(answer));


				}
				panel.repaint();
				}		
		});

		btns[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(CheckAnswer.checkAnswer(submit,answer)==false) {

					if (clicks ==0) {
						num = 3;
						x1 = btns[num].getX();
						y1 = btns[num].getY();
						btns[num].setVisible(false);
						btns[num].setLayout(null);
						panel.repaint();
						clicks += 1;	
					}
					else if (clicks ==1 && btns[num] != btns[3]) {
						x2=btns[3].getX();
						y2=btns[3].getY();
						btns[num].setLocation(x2,y2);
						btns[num].setVisible(true);
						btns[3].setLayout(null);
						btns[3].setLocation(x1,y1);
						btns[3].setVisible(true);
						panel.repaint();
						clicks -= 1;
						
					}
					for ( int i = 0; i < (submit.length/2); i++) {
						submit[i*2] = btns[i].getX();
						submit[(i*2)+1] = btns[i].getY();
					}
					System.out.println("btn0위치: " + btns[0].getX()+ ","+ btns[1].getY());
					System.out.println("btn1위치: " + btns[1].getX()+ ","+ btns[1].getY());
					System.out.println("btn2위치: " + btns[2].getX()+ ","+ btns[2].getY());
					System.out.println("btn3위치: " + btns[3].getX()+ ","+ btns[3].getY());
					System.out.println("btn4위치: " + btns[4].getX()+ ","+ btns[4].getY());
					System.out.println("btn5위치: " + btns[5].getX()+ ","+ btns[5].getY());
					System.out.println("btn6위치: " + btns[6].getX()+ ","+ btns[6].getY());
					System.out.println("btn7위치: " + btns[7].getX()+ ","+ btns[7].getY());
					System.out.println("btn8위치: " + btns[8].getX()+ ","+ btns[8].getY());
					System.out.println(Arrays.toString(submit));
					System.out.println(Arrays.toString(answer));


				}
				panel.repaint();
				}		
		});

		btns[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(CheckAnswer.checkAnswer(submit,answer)==false) {

					if (clicks ==0) {
						num = 4;
						x1 = btns[num].getX();
						y1 = btns[num].getY();
						btns[num].setVisible(false);
						btns[num].setLayout(null);
						panel.repaint();
						clicks += 1;	
					}
					else if (clicks ==1 && btns[num] != btns[4]) {
						x2=btns[4].getX();
						y2=btns[4].getY();
						btns[num].setLocation(x2,y2);
						btns[num].setVisible(true);
						btns[4].setLayout(null);
						btns[4].setLocation(x1,y1);
						btns[4].setVisible(true);
						panel.repaint();
						clicks -= 1;
						
					}
					for ( int i = 0; i < (submit.length/2); i++) {
						submit[i*2] = btns[i].getX();
						submit[(i*2)+1] = btns[i].getY();
					}
					System.out.println("btn0위치: " + btns[0].getX()+ ","+ btns[1].getY());
					System.out.println("btn1위치: " + btns[1].getX()+ ","+ btns[1].getY());
					System.out.println("btn2위치: " + btns[2].getX()+ ","+ btns[2].getY());
					System.out.println("btn3위치: " + btns[3].getX()+ ","+ btns[3].getY());
					System.out.println("btn4위치: " + btns[4].getX()+ ","+ btns[4].getY());
					System.out.println("btn5위치: " + btns[5].getX()+ ","+ btns[5].getY());
					System.out.println("btn6위치: " + btns[6].getX()+ ","+ btns[6].getY());
					System.out.println("btn7위치: " + btns[7].getX()+ ","+ btns[7].getY());
					System.out.println("btn8위치: " + btns[8].getX()+ ","+ btns[8].getY());
					System.out.println(Arrays.toString(submit));
					System.out.println(Arrays.toString(answer));


				}
				panel.repaint();
				}		
		});

		btns[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(CheckAnswer.checkAnswer(submit,answer)==false) {

					if (clicks ==0) {
						num = 5;
						x1 = btns[num].getX();
						y1 = btns[num].getY();
						btns[num].setVisible(false);
						btns[num].setLayout(null);
						panel.repaint();
						clicks += 1;	
					}
					else if (clicks ==1 && btns[num] != btns[5]) {
						x2=btns[5].getX();
						y2=btns[5].getY();
						btns[num].setLocation(x2,y2);
						btns[num].setVisible(true);
						btns[5].setLayout(null);
						btns[5].setLocation(x1,y1);
						btns[5].setVisible(true);
						panel.repaint();
						clicks -= 1;
						
					}
					for ( int i = 0; i < (submit.length/2); i++) {
						submit[i*2] = btns[i].getX();
						submit[(i*2)+1] = btns[i].getY();
					}
					System.out.println("btn0위치: " + btns[0].getX()+ ","+ btns[1].getY());
					System.out.println("btn1위치: " + btns[1].getX()+ ","+ btns[1].getY());
					System.out.println("btn2위치: " + btns[2].getX()+ ","+ btns[2].getY());
					System.out.println("btn3위치: " + btns[3].getX()+ ","+ btns[3].getY());
					System.out.println("btn4위치: " + btns[4].getX()+ ","+ btns[4].getY());
					System.out.println("btn5위치: " + btns[5].getX()+ ","+ btns[5].getY());
					System.out.println("btn6위치: " + btns[6].getX()+ ","+ btns[6].getY());
					System.out.println("btn7위치: " + btns[7].getX()+ ","+ btns[7].getY());
					System.out.println("btn8위치: " + btns[8].getX()+ ","+ btns[8].getY());
					System.out.println(Arrays.toString(submit));
					System.out.println(Arrays.toString(answer));


				}
				panel.repaint();
				}		
		});

		btns[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(CheckAnswer.checkAnswer(submit,answer)==false) {

					if (clicks ==0) {
						num = 6;
						x1 = btns[num].getX();
						y1 = btns[num].getY();
						btns[num].setVisible(false);
						btns[num].setLayout(null);
						panel.repaint();
						clicks += 1;	
					}
					else if (clicks ==1 && btns[num] != btns[6]) {
						x2=btns[6].getX();
						y2=btns[6].getY();
						btns[num].setLocation(x2,y2);
						btns[num].setVisible(true);
						btns[6].setLayout(null);
						btns[6].setLocation(x1,y1);
						btns[6].setVisible(true);
						panel.repaint();
						clicks -= 1;
						
					}
					for ( int i = 0; i < (submit.length/2); i++) {
						submit[i*2] = btns[i].getX();
						submit[(i*2)+1] = btns[i].getY();
					}
					System.out.println("btn0위치: " + btns[0].getX()+ ","+ btns[1].getY());
					System.out.println("btn1위치: " + btns[1].getX()+ ","+ btns[1].getY());
					System.out.println("btn2위치: " + btns[2].getX()+ ","+ btns[2].getY());
					System.out.println("btn3위치: " + btns[3].getX()+ ","+ btns[3].getY());
					System.out.println("btn4위치: " + btns[4].getX()+ ","+ btns[4].getY());
					System.out.println("btn5위치: " + btns[5].getX()+ ","+ btns[5].getY());
					System.out.println("btn6위치: " + btns[6].getX()+ ","+ btns[6].getY());
					System.out.println("btn7위치: " + btns[7].getX()+ ","+ btns[7].getY());
					System.out.println("btn8위치: " + btns[8].getX()+ ","+ btns[8].getY());
					System.out.println(Arrays.toString(submit));
					System.out.println(Arrays.toString(answer));


				}
				panel.repaint();
				}		
		});


		btns[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(CheckAnswer.checkAnswer(submit,answer)==false) {

					if (clicks ==0) {
						num = 7;
						x1 = btns[num].getX();
						y1 = btns[num].getY();
						btns[num].setVisible(false);
						btns[num].setLayout(null);
						panel.repaint();
						clicks += 1;	
					}
					else if (clicks ==1 && btns[num] != btns[7]) {
						x2=btns[7].getX();
						y2=btns[7].getY();
						btns[num].setLocation(x2,y2);
						btns[num].setVisible(true);
						btns[7].setLayout(null);
						btns[7].setLocation(x1,y1);
						btns[7].setVisible(true);
						panel.repaint();
						clicks -= 1;
						
					}
					for ( int i = 0; i < (submit.length/2); i++) {
						submit[i*2] = btns[i].getX();
						submit[(i*2)+1] = btns[i].getY();
					}
					System.out.println("btn0위치: " + btns[0].getX()+ ","+ btns[1].getY());
					System.out.println("btn1위치: " + btns[1].getX()+ ","+ btns[1].getY());
					System.out.println("btn2위치: " + btns[2].getX()+ ","+ btns[2].getY());
					System.out.println("btn3위치: " + btns[3].getX()+ ","+ btns[3].getY());
					System.out.println("btn4위치: " + btns[4].getX()+ ","+ btns[4].getY());
					System.out.println("btn5위치: " + btns[5].getX()+ ","+ btns[5].getY());
					System.out.println("btn6위치: " + btns[6].getX()+ ","+ btns[6].getY());
					System.out.println("btn7위치: " + btns[7].getX()+ ","+ btns[7].getY());
					System.out.println("btn8위치: " + btns[8].getX()+ ","+ btns[8].getY());
					System.out.println(Arrays.toString(submit));
					System.out.println(Arrays.toString(answer));


				}
				panel.repaint();
				}		
		});


		btns[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(CheckAnswer.checkAnswer(submit,answer)==false) {

					if (clicks ==0) {
						num = 8;
						x1 = btns[num].getX();
						y1 = btns[num].getY();
						btns[num].setVisible(false);
						btns[num].setLayout(null);
						panel.repaint();
						clicks += 1;	
					}
					else if (clicks ==1 && btns[num] != btns[8]) {
						x2=btns[8].getX();
						y2=btns[8].getY();
						btns[num].setLocation(x2,y2);
						btns[num].setVisible(true);
						btns[8].setLayout(null);
						btns[8].setLocation(x1,y1);
						btns[8].setVisible(true);
						panel.repaint();
						clicks -= 1;
						
					}
					for ( int i = 0; i < (submit.length/2); i++) {
						submit[i*2] = btns[i].getX();
						submit[(i*2)+1] = btns[i].getY();
					}
					System.out.println("btn0위치: " + btns[0].getX()+ ","+ btns[1].getY());
					System.out.println("btn1위치: " + btns[1].getX()+ ","+ btns[1].getY());
					System.out.println("btn2위치: " + btns[2].getX()+ ","+ btns[2].getY());
					System.out.println("btn3위치: " + btns[3].getX()+ ","+ btns[3].getY());
					System.out.println("btn4위치: " + btns[4].getX()+ ","+ btns[4].getY());
					System.out.println("btn5위치: " + btns[5].getX()+ ","+ btns[5].getY());
					System.out.println("btn6위치: " + btns[6].getX()+ ","+ btns[6].getY());
					System.out.println("btn7위치: " + btns[7].getX()+ ","+ btns[7].getY());
					System.out.println("btn8위치: " + btns[8].getX()+ ","+ btns[8].getY());
					System.out.println(Arrays.toString(submit));
					System.out.println(Arrays.toString(answer));


				}
				panel.repaint();
				}		
		});
		

//실패 시 나오는 레이블
		JButton fail = new JButton() {
			public void paintComponent(Graphics g) {
				ImageIcon pass = new ImageIcon("src/miniproject/images/suddenGame/fail.png");
				g.drawImage(pass.getImage(), 0, 0, 1350, 220, null);
				setOpaque(false); 
				super.paintComponent(g);
			}
		}; 
		fail.setLayout(null);
		fail.setBorderPainted(false);
		fail.setContentAreaFilled(false);
		fail.setFocusPainted(false);
		fail.setBounds(20,630,1350,220);
		fail.setVisible(false);
		fail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ChangePanel.changePanel(mf, panel,new EndingBackSudden(mf,player));
				mf.revalidate();
			}
		});
		panel.add(fail);
		
		
		Font neo = new Font("휴먼엑스포",Font.BOLD,20);
		JLabel tIndi = new JLabel("남은 시간");
		
		
		
		
		//성공 시 나오는 레이블	
		
		JButton pass = new JButton() {
			public void paintComponent(Graphics g) {
				ImageIcon pass = new ImageIcon("src/miniproject/images/suddenGame/pass1.png");
				g.drawImage(pass.getImage(), 0, 0, 1350, 220, null);
				setOpaque(false); 
				super.paintComponent(g);
			}
		}; 
		pass.setLayout(null);
		pass.setBorderPainted(false);
		pass.setContentAreaFilled(false);
		pass.setFocusPainted(false);
		pass.setBounds(20,630,1350,220);
		pass.setVisible(false);
		pass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				ChangePanel.changePanel(mf, panel, new MainMapdispatch(mf,player));
				mf.revalidate();
			}
		});
		this.add(pass);
		
		
		
		
		
		
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tIndi.setText("남은 시간 " + (t-1));
				t--;
				if ((t)==0) {
					timer.stop();
					fail.setVisible(true);
					
					}
				}
		}	
				);
		tIndi.setFont(neo);
		tIndi.setForeground(Color.white);
		tIndi.setLayout(null);
		tIndi.setBounds(1000,20,300,200);
		panel.add(tIndi);
		timer.start();
		
		
		
		
		
		
		
			
			JButton submission = new JButton() {
				public void paintComponent(Graphics g) {
					ImageIcon pass = new ImageIcon("src/miniproject/images/suddenGame/submit.png");
					g.drawImage(pass.getImage(), 0, 0, 150, 50, null);
					setOpaque(false); 
					super.paintComponent(g);
				}
				
			};
			

			submission.setLayout(null);
			submission.setBorderPainted(false);
			submission.setContentAreaFilled(false);
			submission.setFocusPainted(false);
			submission.setBounds(800,50,150,50);
			
			
			//정답확인 버튼!
			
			panel.add(submission);
			
			submission.addMouseListener(new MouseAdapter() {
				
				@Override 
				public void mouseClicked(MouseEvent e) {
					if(CheckAnswer.checkAnswer(answer,submit)==true) {
						timer.stop();
						player.setTotalScore(player.getTotalScore() + score);
						pass.setVisible(true);
						
								
							
					}
					else {//정답이 아니면
						timer.stop();
						fail.setVisible(true);
						fail.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								ChangePanel.changePanel(mf, panel, new EndingBackSudden(mf,player));
								mf.revalidate();
								
							}
						});
					}
				}

				
			});
			


	}

	
}
