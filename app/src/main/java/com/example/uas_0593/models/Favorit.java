package com.example.uas_0593.models;


public class Favorit {

    private String matchId;
    private String image;
    private String matchTitle;
    private String awayScore;
    private String homeScore;
    private String matchDescription;

    public Favorit(String matchId, String image, String matchTitle, String awayScore, String homeScore, String matchDescription) {
        this.matchId = matchId;
        this.image = image;
        this.matchTitle = matchTitle;
        this.awayScore = awayScore;
        this.homeScore = homeScore;
        this.matchDescription = matchDescription;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMatchTitle() {
        return matchTitle;
    }

    public void setMatchTitle(String matchTitle) {
        this.matchTitle = matchTitle;
    }

    public String getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(String awayScore) {
        this.awayScore = awayScore;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public String getMatchDescription() {
        return matchDescription;
    }

    public void setMatchDescription(String matchDescription) {
        this.matchDescription = matchDescription;
    }
}
