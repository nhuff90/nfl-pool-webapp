package info.natehuff.nfl.data.mysql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wager {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String team;
    private double line;
    private int week;
    private double risked;
    private double toWin;
    private String result;
    private double netProfit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public double getLine() {
        return line;
    }

    public void setLine(double line) {
        this.line = line;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public double getRisked() {
        return risked;
    }

    public void setRisked(double risked) {
        this.risked = risked;
    }

    public double getToWin() {
        return toWin;
    }

    public void setToWin(double toWin) {
        this.toWin = toWin;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }
}
