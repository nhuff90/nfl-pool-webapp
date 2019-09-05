package info.natehuff.demo.dto;

public class PickWithGame {

    Pick pick;
    Game game;
    boolean isCovering;


    public PickWithGame(Pick pick, Game game, boolean isCovering) {
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

    public boolean isCovering() {
        return isCovering;
    }

    public void setCovering(boolean isCovering) {
        isCovering = isCovering;
    }

    @Override
    public String toString() {
        return "PickWithGame{" +
                "pick=" + pick +
                ", game=" + game +
                ", isCovering=" + isCovering +
                '}';
    }
}
