package info.natehuff.demo.dto;

import info.natehuff.demo.dto.enums.GameProgress;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class Game {

    @Id
    @GeneratedValue
    private Long id;
    private String eid;
    private int week;
    private String homeTeam;
    private String homeScore;
    private String AwayTeam;
    private String AwayScore;
    private String gameProgress;

    public Game(String eid, int week, String homeTeam, String homeScore, String awayTeam, String awayScore, String gameProgress) {
        this.eid = eid;
        this.week = week;
        this.homeTeam = homeTeam;
        this.homeScore = homeScore;
        AwayTeam = awayTeam;
        AwayScore = awayScore;
        this.gameProgress = gameProgress;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public String getAwayTeam() {
        return AwayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        AwayTeam = awayTeam;
    }

    public String getAwayScore() {
        return AwayScore;
    }

    public void setAwayScore(String awayScore) {
        AwayScore = awayScore;
    }

    public String getGameProgress() {
        return gameProgress;
    }

    public void setGameProgress(String gameProgress) {
        this.gameProgress = gameProgress;
    }

    @Override
    public String toString() {
        return "Game{" +
                "eid='" + eid + '\'' +
                ", week=" + week +
                ", homeTeam='" + homeTeam + '\'' +
                ", homeScore='" + homeScore + '\'' +
                ", AwayTeam='" + AwayTeam + '\'' +
                ", AwayScore='" + AwayScore + '\'' +
                ", gameProgress=" + gameProgress +
                '}';
    }
}
