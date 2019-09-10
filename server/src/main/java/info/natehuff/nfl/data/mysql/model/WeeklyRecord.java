package info.natehuff.nfl.data.mysql.model;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Entity(name = "weekly_record")
public class WeeklyRecord {
    @Id
    private Integer week;
    private Integer wins;
    private Integer losses;

    public WeeklyRecord(Integer week, Integer wins, Integer losses) {
        this.week = week;
        this.wins = wins;
        this.losses = losses;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }
}
