package info.natehuff.demo.dto.enums;

public enum GameProgress {
    NOT_STARTED("Not Started"), IN_PROGRESS("In Progress"), FINISHED("Finished");

    private final String progress;

    GameProgress(final String progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return progress;
    }
}
