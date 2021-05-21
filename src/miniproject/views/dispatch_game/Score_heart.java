package miniproject.views.dispatch_game;

public class Score_heart {
   int x;      // 하트 먹어야하는 장애물의 x 좌표
   int y;      // 하트 먹어야하는 장애물의 y 좌표
   int speed;   // 하트 먹어야하는 장애물의 속도
   
   int score;   // 점수
   int total; // 총점
   
   public Score_heart(int x, int y, int speed) {
      this.x = x;
      this.y = y;
      this.speed = speed;
   }
   
   public void move() {
      x -= speed ;      // 미사일 속도 만큼 이동
   }
}