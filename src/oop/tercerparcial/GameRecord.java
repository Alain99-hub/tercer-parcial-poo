package oop.tercerparcial;

public class GameRecord {
    private String playerName;
    private int score;

    public GameRecord(int score, String playerName) {
        this.score = score;
        this.playerName = playerName;
    }

    public GameRecord() {

    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
