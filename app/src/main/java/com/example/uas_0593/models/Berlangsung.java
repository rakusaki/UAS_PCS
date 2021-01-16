package com.example.uas_0593.models;

public class Berlangsung {


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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Berlangsung(String matchTitle, String awayScore, String homeScore, String matchDescription, String image, String matchId) {
        this.matchTitle = matchTitle;
        this.awayScore = awayScore;
        this.homeScore = homeScore;
        this.matchDescription = matchDescription;
        this.image = image;
        this.matchId=matchId;
    }

    private String matchTitle, awayScore, homeScore, matchDescription;
    private String image;

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    private String matchId;

}
