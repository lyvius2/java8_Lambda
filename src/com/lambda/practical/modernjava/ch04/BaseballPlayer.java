package com.lambda.practical.modernjava.ch04;

public class BaseballPlayer implements Comparable<BaseballPlayer> {
    private String teamName;
    private String playerName;
    private String position;
    private int ranking;

    @Override
    public int compareTo(BaseballPlayer baseballPlayer) {
        // TODO Auto-generated method stub
        return this.playerName.compareTo(baseballPlayer.getPlayerName());
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getRanking() {
        return this.ranking;
    }
}