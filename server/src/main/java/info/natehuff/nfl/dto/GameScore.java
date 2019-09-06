package info.natehuff.nfl.dto;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class GameScore {

    @Id
    @GeneratedValue
    private Long id;
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    String gameProgress;

    public GameScore(String homeTeam, int homeScore, String awayTeam, int awayScore, String gameProgress) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.gameProgress = gameProgress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public String getGameProgress() {
        return gameProgress;
    }

    public void setGameProgress(String gameProgress) {
        this.gameProgress = gameProgress;
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "id=" + id +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                ", gameProgress='" + gameProgress + '\'' +
                '}';
    }
}
