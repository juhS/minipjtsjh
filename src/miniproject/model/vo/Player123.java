package miniproject.model.vo;

import java.io.Serializable;

public class Player123 implements Serializable{
	private String userId;
	private int totalScore;
	private int danceScore;
	private int singScore;
	private int playerX = 0;
	private int playerY = 0;
	private int quest;

	public Player123() {}


	public Player123(String userId, int totalScore, int danceScore, int singScore, int playerX, int playerY, int quest) {
		super();
		this.userId = userId;
		this.totalScore = totalScore;
		this.danceScore = danceScore;
		this.singScore = singScore;
		this.playerX = playerX;
		this.playerY = playerY;
		this.quest = quest;
	}


	@Override
	public String toString() {
		return "Player [userId=" + userId + ", totalScore=" + totalScore + ", danceScore=" + danceScore + ", singScore="
				+ singScore + ", playerX=" + playerX + ", playerY=" + playerY + ", quest=" + quest + "]";
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getTotalScore() {
		return totalScore;
	}


	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}


	public int getDanceScore() {
		return danceScore;
	}


	public void setDanceScore(int danceScore) {
		this.danceScore = danceScore;
	}


	public int getSingScore() {
		return singScore;
	}


	public void setSingScore(int singScore) {
		this.singScore = singScore;
	}


	public int getPlayerX() {
		return playerX;
	}


	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}


	public int getPlayerY() {
		return playerY;
	}


	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}


	public int getQuest() {
		return quest;
	}


	public void setQuest(int quest) {
		this.quest = quest;
	}



	
}
