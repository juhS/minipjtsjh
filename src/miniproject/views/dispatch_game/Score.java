package miniproject.views.dispatch_game;

public class Score {

	int x;		// 디스패치 피하는 장애물의 x 좌표
	int y;		// 디스패치 피하는 장애물의 y 좌표
	int speed;	// 디스패치 피하는 장애물의 속도
	
	int score;	// 점수
	int total; // 총점
	
	public Score(int x, int y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.score = score;
	}
	
	public void move() {
		x -= speed ;		// 미사일 속도 만큼 이동
	}
}
