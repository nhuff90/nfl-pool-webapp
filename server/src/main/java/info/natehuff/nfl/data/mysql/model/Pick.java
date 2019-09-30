package info.natehuff.nfl.data.mysql.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity(name = "pick")
public class Pick {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String team;
    private double line;
    private int week;
    private double risked;
    private double toWin;
    @OneToOne(mappedBy="pick", cascade=CascadeType.ALL)
    private PickResult pickResult;
    private String parleyId;

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

    public String getParleyId() {
        return parleyId;
    }

    public void setParleyId(String parleyId) {
        this.parleyId = parleyId;
    }

    @Override
    public String toString() {
        return "Pick{" +
                "id=" + id +
                ", team='" + team + '\'' +
                ", line=" + line +
                ", week=" + week +
                ", risked=" + risked +
                ", toWin=" + toWin +
                ", pickResult=" + pickResult +
                ", parleyId='" + parleyId + '\'' +
                '}';
    }
}
