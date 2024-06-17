package snakeladder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    private final Deque<Player> players;
    private Board board;
    private Dice dice;
    private Player winner;

    public Game() {
        this.players = new LinkedList<>();
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        Player player1 = new Player("p1");
        Player player2 = new Player("p2");
        players.add(player1);
        players.add(player2);
    }

    public void startGame() {
        while (winner == null) {
            Player playerTurn = findPlayer();
            System.out.println("player turn is:" + playerTurn.getPlayerId() + " current position is: " + playerTurn.getCurrentPosition());
            int diceNumbers = dice.rollDice();
            int playerNewPosition = playerTurn.getCurrentPosition() + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.setCurrentPosition(playerNewPosition);

            System.out.println("player turn is:" + playerTurn.getPlayerId() + " new Position is: " + playerNewPosition);
            //check for winning condition
            if (playerNewPosition >= board.getCells().size() * board.getCells().size() - 1) {
                winner = playerTurn;
            }

        }
        System.out.println("WINNER IS:" + winner.getPlayerId());
    }


    private Player findPlayer() {
        Player player = players.removeFirst();
        players.add(player);
        return player;
    }

    private int jumpCheck(int playerNewPosition) {

        if (playerNewPosition > board.getCells().size() * board.getCells().size() - 1) {
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if (cell.getJump() != null && cell.getJump().getStart() == playerNewPosition) {
            String jumpBy = (cell.getJump().getStart() < cell.getJump().getEnd()) ? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.getJump().getEnd();
        }
        return playerNewPosition;
    }

}
