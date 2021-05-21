package miniproject.views.somang;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;

public class MiniGameSsing_test {
	private MainFrame mf;
	private JPanel panel;
	private JTextField input; // 저장할공간 타입 선언
	private JTextField input2;
	private JTextField input3;
	
	private int cnt = 0;
	private int num;
	
	private String one = "";
	private String two = "";
	private String three = "";
	
	private boolean fone = false;
	private boolean ftwo = false;
	private boolean fthree = false;
	private boolean isStop;
	
	private Thread thread;
	private Timer2 timer = new Timer2(mf,panel);
		
	private Player123 player;
	
	private int jum = 0;
	
	private Thread t1= timer;

	public MiniGameSsing_test(MainFrame mf, JPanel panel, int num, JTextField input, JTextField input2, JTextField input3, Player123 player) {
		this.mf = mf;
		this.panel = panel;
		this.num = num;
		this.input = input;
		this.input2 = input2;
		this.input3 = input3;
		this.player = player;

		
		//t1.start();
		 
		
	}

	//점수
	public MiniGameSsing_test(int jum) {
		this.jum = jum;		
	}
	
	public void cancel() {
		
		thread.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();

		}

		timer.interrupt();
		System.out.println(timer);
	}

	

	public void ssingNext() {
		// 통과이면(cnt 2이상이고 3이되면) 노래점수+1
		// 타이머 stop하고 다음 화면 넘어가기
		MiniGameSsing_Win gp = new MiniGameSsing_Win(mf, player);
		gp.jumsu(jum);
		ChangePanel.changePanel(mf, panel, gp);
		stop();
	}

	
	
	public void cancel2() {

		timer	= new Timer2(mf, panel);



		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
		
		
		timer.interrupt();


	}
	public void ssingNext_lose() {
		// 통과이면(cnt 2이상이고 3이되면) 노래점수+1
		// 타이머 stop하고 다음 화면 넘어가기
		MiniGameSsing_lose gp = new MiniGameSsing_lose(mf,player,jum);
		gp.jumsu(jum);
		ChangePanel.changePanel(mf, panel, gp);
		stop();
	}
	
	public final void stop() {
		timer	= new Timer2(mf, panel);

		timer.interrupt();
	}
	
	// 테스트 통과 여부
	public void StestPass(String[] inputArr) {
		String[][] answers = {{"얼굴", "몸매", "모든것이"}, 
							{"당신","나는","배터리"},
							{"당신", "동반자", "선물"},
							{"가인","가인","가인"},
							{"뭐야뭐야","뭐야","내버려"},
							{"유행가","나도","쿵쿵"},
							{"숫자","진짜","가슴"},
							{"땡벌","기다리다","추워요"},
							{"만드레","나는","향기속에"},
							{"오늘","사랑","헤어지면"}		
		};
		
		

		// num값에 따른 정답 비교
		switch (num) {
		case 1:
			if (answers[0][0].equals(inputArr[0])) {
				// 값 한개씩 비교 후 정답이면 cnt++ -> cnt가 2이상이면 통과 -> 다음 장면으로 넘어가기?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;

				}

				System.out.println(cnt);
			}
			if (answers[0][1].equals(inputArr[1])){
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[0][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			break;

		case 2:
			if (answers[1][0].equals(inputArr[0])) {
				// 값 한개씩 비교 후 정답이면 cnt++ -> cnt가 2이상이면 통과 -> 다음 장면으로 넘어가기?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[1][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[1][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			break;

		case 3:
			if (answers[2][0].equals(inputArr[0])) {
				// 값 한개씩 비교 후 정답이면 cnt++ -> cnt가 2이상이면 통과 -> 다음 장면으로 넘어가기?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[2][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[2][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			break;

		case 4:
			if (answers[3][0].equals(inputArr[0])) {
				// 값 한개씩 비교 후 정답이면 cnt++ -> cnt가 2이상이면 통과 -> 다음 장면으로 넘어가기?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[3][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[3][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			break;

		case 5:
			if (answers[4][0].equals(inputArr[0])) {
				// 값 한개씩 비교 후 정답이면 cnt++ -> cnt가 2이상이면 통과 -> 다음 장면으로 넘어가기?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[4][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[4][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			break;

		case 6:
			if (answers[5][0].equals(inputArr[0])) {
				// 값 한개씩 비교 후 정답이면 cnt++ -> cnt가 2이상이면 통과 -> 다음 장면으로 넘어가기?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[5][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[5][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			break;

		case 7:
			if (answers[6][0].equals(inputArr[0])) {
				// 값 한개씩 비교 후 정답이면 cnt++ -> cnt가 2이상이면 통과 -> 다음 장면으로 넘어가기?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[6][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[6][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			break;

		case 8:
			if (answers[7][0].equals(inputArr[0])) {
				// 값 한개씩 비교 후 정답이면 cnt++ -> cnt가 2이상이면 통과 -> 다음 장면으로 넘어가기?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[7][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[7][2].equals(inputArr[2])){
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			break;

		case 9:
			if(answers[8][0].equals(inputArr[0])) {
				// 값 한개씩 비교 후 정답이면 cnt++ -> cnt가 2이상이면 통과 -> 다음 장면으로 넘어가기?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[8][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[8][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			break;

		case 10:
			if (answers[9][0].equals(inputArr[0])) {
				// 값 한개씩 비교 후 정답이면 cnt++ -> cnt가 2이상이면 통과 -> 다음 장면으로 넘어가기?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[9][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[9][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			break;
		}
		
		ifTest();
	}

	
	public void ifTest() {
		if (cnt >= 2) {
			// 점수 획득 +1
			jum += 1;
			
			System.out.println("통과");
			System.out.println("cnt_pass : " + cnt);
			ssingNext();
			t1.stop();
		} 
		else if (cnt < 2 ) {
				ssingNext_lose();
				System.out.println("cnt" + cnt);

					// 점수 획득 없음
					
					cancel2();
				
					System.out.println("실패!");
			}
			
	}

}