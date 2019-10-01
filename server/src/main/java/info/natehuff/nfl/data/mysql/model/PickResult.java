package info.natehuff.nfl.data.mysql.model;

import info.natehuff.nfl.dto.PickWithGame;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity(name = "pickResult")
public class PickResult {
    @Id
    @Column(name = "ID")
    private Integer id;
    @OneToOne
    @PrimaryKeyJoinColumn(name="ID", referencedColumnName="ID")
    private Pick pick;
    private int week;
    private String covered;
    private double netProfit;

    public PickResult(PickWithGame pickWithGame) {
        this.id = pickWithGame.getPick().getId();
        this.pick = pickWithGame.getPick();
        this.week = pickWithGame.getPick().getWeek();
        this.covered = pickWithGame.getCovering().name();
        if (this.covered == PickWithGame.Covered.COVERED.name()) {
            this.netProfit = pickWithGame.getPick().getToWin();
        } else if (this.covered == PickWithGame.Covered.LOSS.name()){
            this.netProfit = pickWithGame.getPick().getRisked() * -1;
        } else {
            this.netProfit = 0;
        }
    }
    public PickResult(PickWithGame pickWithGame, PickWithGame.Covered covered) {
        this.id = pickWithGame.getPick().getId();
        this.pick = pickWithGame.getPick();
        this.week = pickWithGame.getPick().getWeek();
        this.covered = covered.name();
        if (this.covered == PickWithGame.Covered.COVERED.name()) {
            this.netProfit = pickWithGame.getPick().getToWin();
        } else if (this.covered == PickWithGame.Covered.LOSS.name()){
            this.netProfit = pickWithGame.getPick().getRisked() * -1;
        } else {
            this.netProfit = 0;
        }
    }

    public String getCovered() {
        return covered;
    }

    public void setCovered(PickWithGame.Covered covered) {
        this.covered = covered.name();
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}
