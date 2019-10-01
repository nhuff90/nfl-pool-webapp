package info.natehuff.nfl.dto;

import info.natehuff.nfl.data.mysql.model.Pick;

public class PickWithGame {
    public enum Covered
    {
        COVERED, LOSS, TIED;
    }

    private Pick pick;
    private Game game;
    private Covered isCovering;


    public PickWithGame(Pick pick, Game game, Covered isCovering) {
        this.pick = pick;
        this.game = game;
        this.isCovering = isCovering;
    }

    public Pick getPick() {
        return pick;
    }

    public void setPick(Pick pick) {
        this.pick = pick;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Covered getCovering() {
        return isCovering;
    }

    public void setCovering(Covered isCovering) {
        this.isCovering = isCovering;
    }

    @Override
    public String toString() {
        return "PickWithGame{" +
                "pick=" + pick +
                ", gameScore=" + game +
                ", getCovering=" + isCovering +
                '}';
    }
}
