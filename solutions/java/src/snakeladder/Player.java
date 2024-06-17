package snakeladder;

public class Player {
    private int currentPosition;
    private final String playerId;

    public Player(String playerId) {
        this.playerId = playerId;
        currentPosition = 0;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setCurrentPosition(int position) {
        currentPosition = position;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
