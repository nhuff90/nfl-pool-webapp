package info.natehuff.nfl.data.mysql.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Record {
    protected Integer wins;
    protected Integer losses;

    public Record(Integer wins, Integer losses) {
        this.wins = wins;
        this.losses = losses;
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
