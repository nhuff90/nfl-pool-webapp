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
    private boolean covered;
    private double netProfit;

    public PickResult(PickWithGame pickWithGame) {
        this.id = pickWithGame.getPick().getId();
        this.pick = pickWithGame.getPick();
        this.covered = pickWithGame.isCovering();
        if (this.covered) {
            this.netProfit = pickWithGame.getPick().getToWin();
        } else {
            this.netProfit = pickWithGame.getPick().getRisked() * -1;
        }
    }

    public boolean getCovered() {
        return covered;
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }
}