package miniproject.views.dispatch_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.ending.EndingBack01;
import miniproject.views.ending.EndingBack02;
import miniproject.views.ending.EndingBack03;

public class DispatchPanel extends JPanel implements KeyListener{
	private static final int SCREEN_WIDTH = 1400;
	private static final int SCREEN_HEIGHT = 900;
	MainFrame mf;         //MainFrame 에서 프레임 넘겨받는 변수
	JPanel panel;      //패널의 타입 선정
	Player123 player;

	int x = 100 ;      // player의 초기 x 좌표 위치
	int y = 100 ;       // player의 초기 y 좌표 위치

	int bx = 0;             //전체 배경 스크롤 용 변수

	boolean KeyUp = false;      //키리스너 결정 변수 (위)
	boolean KeyDown = false;   //키리스너 결정 변수 (아래)
	boolean KeyLeft = false;   //키리스너 결정 변수 (왼쪽)
	boolean KeyRight = false;   //키리스너 결정 변수 (오른쪽)
	boolean KeySpace = false;   //케릭터 현재 좌표 위치 확인 변수
	
	boolean stopAll = false;

	int cnt = 0;            //플레이어 발생시키는 카운터 변수
	int cnt2 = 0;            //하트 발생시키는 카운터 변수
	int cnt3 = 0;            //별 발생시키는 카운터 변수

	int player_Speed;         // 유저의 케릭터가 움직이는 속도를 조절할 변수
	int score_Speed;         // 점수가 날라가는 속도 조절할 변수
	int dispatch_Speed;      // 디스패치가 날라오는 속도 조절할 변수   
	int star_Speed;         // 별이 날라오는 속도 조절할 변수
	int heart_Speed;      // 하트가 날라오는 속도 조절할 변수
	int player_Status = 0;      // 유저 캐릭터 상태 체크 변수 0: 평상시, 1: 충돌
	int game_Score = 0;          // 게임 점수 계산

	Timer timer;
	private int timeLeft = 30;      //남은 시간 30초로 설정
	private JLabel lbTimeLeft;      //"남은 시간 : " 이라는 문자열 출력 라벨
	private JLabel totalScore;      //총 점수 라벨에 붙일때 쓰는 변수
	private JTextField printText;   //총 점수 출력창

	Thread thPlayer;            //플레이어 스레드
	Thread thStar;               //별 스레드
	Thread thHeart;               //하트 스레드


	Image bg_img;            // 배경화면 이미지
	Image player_img;         // 플레이어 이미지

	Image dispatch_img;         // 피해야 할 디스패치 이미지
	Image heart_img;         // 먹어야 할 선물하트 이미지
	Image star_img;            // 먹어야 할 선물스타 이미지

	ArrayList<Score> Score_List = new ArrayList<Score>();               //디스패치 속도, x와 y 좌표를 넣어두고 받아오는 list
	ArrayList<Score_heart> Scoreh_List = new ArrayList<Score_heart>();      //하트 속도, x와 y 좌표를 넣어두고 받아오는 list
	ArrayList<Score_star> Scores_List = new ArrayList<Score_star>();      //별 속도, x와 y 좌표를 넣어두고 받아오는 list

	Image buffImage;      //이중 버퍼 생성
	Graphics buffg;         //이중 버퍼 이미지를 그리기 위한 그래픽 객체 생성

	//점수별 클래스 접근키
	Score sc;            //디스패치 클래스에 접근 변수
	Score_heart sc_heart;   //하트 클래스에 접근 변수
	Score_star sc_star;      //별 클래스에 접근 변수


	public DispatchPanel (MainFrame mf, Player123 player) {
		System.out.println(player.getUserId());
		this.mf = mf;
		panel = this;
		this.player = player;

		init();            //이미지 설정과 게임 스코어 초기화 및 속도 설정
		start();         //스레드 실행 및 타이머와 paint 그리기 메소드 실행
		setFocusable(true);   //포커스를 프레임이 아닌 패널에다 주기
		KeyProcess();      //키리스너 작동 부분
	}

	public void init() {
		//이미지 넣어주고 게임 스코어 초기화 , 속도 설정

		//플레이어 이미지
		player_img = new ImageIcon("src/miniproject/images/dispatch_images/chracter/CharactersM.gif"
				+ "").getImage().getScaledInstance(80, 80, 0);
		//점수 이미지, getScaledInstance 의 마지막 인자로 java.awt.Image.SCALE_SMOOTH 를 써보자( 선택 )
		dispatch_img = new ImageIcon("src/miniproject/images/dispatch_images/miniGame/score_avoid.png").getImage().getScaledInstance(80, 80, 0);
		heart_img = new ImageIcon("src/miniproject/images/dispatch_images/miniGame/score_heart.png").getImage().getScaledInstance(80, 80, 0);
		star_img = new ImageIcon("src/miniproject/images/dispatch_images/miniGame/score_star.png").getImage().getScaledInstance(80, 80, 0);
		//전체 배경화면 이미지
		bg_img = new ImageIcon("src/miniproject/images/dispatch_images/miniGame/background.png").getImage().getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, 0);

		game_Score = player.getTotalScore();          //게임 스코어 초기화

		player_Speed = 10;    //유저 케릭터 움직이는 속도 설정
		score_Speed = 5;    //점수가 날라오는 속도 설정, 높을 수록 빨라짐

		dispatch_Speed = 2;   //디스패치 속도 설정
		heart_Speed= 2;      //하트 속도 설정
		star_Speed = 2;      //별 속도 설정

		Image talk = new ImageIcon("src/miniproject/images/ssing/talkframe.png")
				.getImage().getScaledInstance(800, 400,java.awt.Image.SCALE_SMOOTH );

		totalScore = new JLabel();
		totalScore.setIcon(new ImageIcon(talk));
		totalScore.setLayout(null);
		totalScore.setBounds(300,0,1000,1000);
		totalScore.setVisible(false);
		this.add(totalScore);
		revalidate();


		lbTimeLeft = new JLabel("시간 : ");
		lbTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lbTimeLeft.setFont(new Font("휴먼엑스포", Font.BOLD, 30));
		lbTimeLeft.setForeground(Color.WHITE);
		lbTimeLeft.setBounds(100,20,250,200);
		this.add(lbTimeLeft);
		revalidate();

	}


	public void start() {

		addKeyListener(this);
		KeyProcess();      //키 동작


		thPlayer = new playerThread();
		thPlayer.start();
		repaint();
		
		thStar = new starThread();
		thStar.start();
		repaint();

		thHeart = new heartThread();
		thHeart.start();
		repaint();

		timer = new Timer(1000, new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				if(timeLeft == 0) {
					lbTimeLeft.setText("남은시간  : ");
					timer.stop();
					stopAll = true;			//스레드 멈출 flag
					if(game_Score >= 500) {
						ChangePanel.changePanel(mf, panel, new EndingBack03(mf, player));
						mf.revalidate();
						
					}else if(game_Score >= 250 && game_Score <= 499) {
						ChangePanel.changePanel(mf, panel, new EndingBack02(mf, player));
						mf.revalidate();
						
					}else if(game_Score > 1 && game_Score < 250) {
						ChangePanel.changePanel(mf, panel, new EndingBack01(mf, player));
						mf.revalidate();
					}	
					

				}
				lbTimeLeft.setText("남은시간 : " + timeLeft);
				timeLeft--;

			}
		});

		timer.start();

		if(game_Score < 0 || timeLeft == 0) {
			timer.stop();
			stopAll = true;			//스레드 멈출 flag
			
		}




	}

	class starThread extends Thread{
		public starThread() {

		}

		@Override
		public void run() {
			try{
				while(true) {
					if(!(stopAll)) {
					repaint();
					cnt++;
					System.out.println("cnt1 : " + cnt);
					sleep(10);
					starProcess();
					}
				}

			} catch(Exception e) {
				System.out.println("starThread 오류");
				e.printStackTrace();
			}
		}

		public void starProcess() {
			//별 충돌 판정
			for(int i = 0; i < Scores_List.size(); ++i) {
				sc_star = (Score_star) (Scores_List.get(i));
				sc_star.move();
				if(sc_star.x < -200) {
					Scores_List.remove(i);
				}

				if(Crash(x,y, sc_star.x, sc_star.y, player_img, star_img)) {

					Scores_List.remove(i);   //별 제거
					game_Score += 30;      //별을 먹으면 +30점
					System.out.println("game_score : " + game_Score);
				}

				if(game_Score < 0) {
					thStar.interrupt();

				}
			}
			//점수 생성
			if(cnt % 200 == 0) {
				//별 생성

				for(int m = (int)(Math.random()*900 + 1); m < (SCREEN_HEIGHT -80); m+=500) {
					sc_star = new Score_star(SCREEN_WIDTH + 
							(int)(Math.random()*70 + 1), (int)(Math.random()*720 + 1), star_Speed + (int)(Math.random()*7 + 3));
					Scores_List.add(sc_star);
				}

			}

		}
	}

	class heartThread extends Thread{
		public heartThread() {

		}

		@Override
		public void run() {
			try{
				while(true) {
					if(!(stopAll)) {
					repaint();
					cnt2++;
					Thread.sleep(10);
					heartProcess();
					}
				}

			} catch(Exception e) {
				System.out.println("heartThread 오류");
				e.printStackTrace();
			}
		}
		public void heartProcess() {
			//하트 충돌 판정
			for(int i = 0; i < Scoreh_List.size(); ++i) {
				sc_heart = (Score_heart) (Scoreh_List.get(i));
				sc_heart.move();
				if(sc_heart.x < -200) {
					Scoreh_List.remove(i);
				}

				if(Crash(x,y, sc_heart.x, sc_heart.y, player_img, heart_img)) {

					Scoreh_List.remove(i);   //별 제거
					game_Score += 30;      //별을 먹으면 +30점
					System.out.println("game_score : " + game_Score);
				}

				if(game_Score < 0) {
					thHeart.interrupt();

				}
			}
			if(cnt2 % 200 == 0) {

				//하트 생성 , x 좌표  & 속도 제어 값 전달
				for(int k = (int)(Math.random()*720+ 1); k < (SCREEN_HEIGHT -80); k+=(int)(Math.random()*720+ 1)) {
					sc_heart = new Score_heart(SCREEN_WIDTH + 
							(int)(Math.random()*70 + 1),(int)(Math.random()*780+ 1), heart_Speed + (int)(Math.random()*7+ 3));
					Scoreh_List.add(sc_heart);
				}
			}
		}

	}

	class playerThread extends Thread {

		public playerThread() {

		}

		@Override
		public void run() {
			try{
				while(true) {
					if(!(stopAll)) {
					KeyProcess();      //키 동작
					repaint();
					cnt3++;
					Thread.sleep(30);
					playerProcess();
					}
				}
			} catch(Exception e) {
				System.out.println("run() 오류");
				e.printStackTrace();
			}
		}

		public void playerProcess() {

			for(int i = 0; i < Score_List.size(); ++i) {
				sc = (Score) (Score_List.get(i));
				sc.move();
				if(sc.x < -200 ) {
					Score_List.remove(i);
				}

				//디스패치 충돌 판정
				if (Crash(x, y, sc.x, sc.y, player_img, dispatch_img)) {
					//플레이어와 적의 충돌을 판정하여 check값을 리턴 받아 true면 아래를 실행
					Score_List.remove(i);   //적을 제거
					game_Score -= 10;      //디스 패치를 먹으면 -20점
					System.out.println("game_score : " + game_Score);

				}

				if(game_Score < 0) {
					stopAll = true;			//스레드 멈출 flag
					thPlayer.interrupt();
					timer.stop();
					System.out.println("방구석 엔딩");
					ChangePanel.changePanel(mf, panel, new EndingBack01(mf, player));
				}            
			}

			if(cnt3 % 100 == 0) {

				//i 는 위치값, 증감값에 따라 배치 조절 가능,  
				//디스패치 생성, x좌표 & 속도 제어 값 전달
				for(int j = (int)(Math.random()*720+ 1); j < (SCREEN_HEIGHT -20); j+=45) {
					sc = new Score(SCREEN_WIDTH + 
							(int)(Math.random()*500 + 1), (int)(Math.random()*720+ 1), dispatch_Speed +(int)(Math.random()*7+ 3));
					Score_List.add(sc);

				}
			}
		}

	}

	public void Crash() {}       //위치 이동용
	public boolean Crash(int x1, int y1, int x2, int y2, Image player_img, Image dispatch_img) {
		//해당 이미지의 넓이, 높이값을 계산
		boolean check = false;

		if(Math.abs((x1 + player_img.getWidth(null) / 2) - (x2 + dispatch_img.getWidth(null) / 2)) <
				(dispatch_img.getWidth(null) / 2 + player_img.getWidth(null) / 2) 
				&& Math.abs((y1 + player_img.getHeight(null) / 2)  - (y2 + dispatch_img.getHeight(null) /2)) <
				(dispatch_img.getHeight(null) / 2 + player_img.getHeight(null) /2 )) {
			//이미지 넓이, 높이값을 바로 받아 계산

			check = true;   //위 값이 true면 check에 true를 전달
		} else {
			check = false;
		}

		return check;      //check의 값을 메소드에 리턴 시킴
	}

	public void paint() {}
	public void paint(Graphics g) {
		setFocusable(true);
		requestFocus();
		buffImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		buffg = buffImage.getGraphics();
		update(g);
	}

	public void update() {}
	public void update(Graphics g) {
		Draw_Background(); // 배경 이미지 그리기 메소드 실행
		Draw_Player(); // 플레이어를 그리는 메소드 이름 변경

		Draw_Score();   // 적기 그리기

		Draw_StatusText();   // 상태 표시 텍스트를 그리는 메소드 실행

		Draw_Ending();      //엔딩 그리는 부분

		Draw_Timer();      //타이머 그리는 부분

		g.drawImage(buffImage, 0, 0, this);      //지우지 말기 이중 버퍼 설정부분
	}

	public void Draw_Timer() {
		buffg.drawString("남은 시간은 : " + timeLeft +"입니다.",700, 70);
	}

	public void Draw_Ending() {
	}

	public void Draw_Background() {
		if(game_Score >= 0) {
			//화면 지우기 명령
			buffg.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
			if(bx> - 1400) {
				buffg.drawImage(bg_img, bx, 0, this);
				bx -= 1;
				buffg.drawImage(bg_img, bx+1401, 0, this);
			} else {
				bx = 0;
			}
		} else {
			buffg.drawImage(bg_img, bx, 0, this);
			buffg.drawImage(bg_img, bx+1399, 0, this);
		}
	}

	public void Draw_Player() {
		buffg.drawImage(player_img, x, y, this);
	}

	public void Draw_StatusText() {
		//샅애 체크용 텍스트를 그립니다.
		buffg.setFont(new Font("serif", Font.BOLD, 20));
		//폰트 설정 : 돋움, 굵게, 사이즈 20

		buffg.drawString("Score : "  + game_Score, 1000, 70);
		//좌표 x : 1000, y : 70 에 스코어를 표시

	}   

	public void Draw_Score() {

		//디스패치 그림 그리기
		for (int i = 0; i < Score_List.size(); ++i) {
			sc = (Score) (Score_List.get(i));
			buffg.drawImage(dispatch_img, sc.x,   sc.y, this);
		}

		//하트 그림 그리기
		for ( int i= 0; i < Scoreh_List.size(); ++i) {
			sc_heart = (Score_heart) (Scoreh_List.get(i));
			buffg.drawImage(heart_img, sc_heart.x, sc_heart.y, this);
		}

		//별 그림 그리기
		for ( int i= 0; i < Scores_List.size(); ++i) {
			sc_star = (Score_star) (Scores_List.get(i));
			buffg.drawImage(star_img, sc_star.x, sc_star.y, this);
		}

	}

	public void KeyProcess() {
		if(KeyUp == true) {
			if (y > 20)
				y -= 10;               //케릭터가 보여지는 화면 위로 못 넘어가게 합니다.
		}

		if(KeyDown == true) {
			if (y + player_img.getHeight(null)+40 < SCREEN_HEIGHT)
				y += 10;               //케릭터가 보여지는 화면 아래로 못 넘어가게 합니다.
		}

		if(KeyLeft == true) {
			if(x > 0)
				x -= 10;               //케릭터가 보여지는 화면 왼쪽으로 못 넘어가게 합니다.
		}

		if(KeyRight == true) {
			if(x + player_img.getWidth(null) < SCREEN_WIDTH)
				x += 10;               //케릭터가 보여지는 화면 오른쪽으로 못 넘어가게 합니다.
		}

		if(KeySpace == true) {
			//좌표 확인용
			System.out.println( x+ ", " + y);

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {      //키를 눌렀을 때 동작
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP :
			KeyUp = true;
			break;

		case KeyEvent.VK_DOWN :
			KeyDown = true;
			break;

		case KeyEvent.VK_LEFT :
			KeyLeft = true;
			break;

		case KeyEvent.VK_RIGHT :
			KeyRight = true;
			break;

		case KeyEvent.VK_SPACE :
			KeySpace = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {      //키를 떼었을 때 동작

		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP :
			KeyUp = false;
			break;

		case KeyEvent.VK_DOWN :
			KeyDown = false;
			break;

		case KeyEvent.VK_LEFT :
			KeyLeft = false;
			break;

		case KeyEvent.VK_RIGHT :
			KeyRight = false;
			break;

		case KeyEvent.VK_SPACE :
			KeySpace = false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}