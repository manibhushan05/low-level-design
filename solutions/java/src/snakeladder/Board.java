package snakeladder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private final List<List<Cell>> cells;

    public Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        this.cells = new ArrayList<>();
        initializeCells(boardSize);
        addLadder(numberOfLadders);
        addSnakes(numberOfSnakes);
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    private void initializeCells(int boardSize) {
        for (int i = 0; i < boardSize; i++) {
            List<Cell> columns = new ArrayList<>();
            for (int j = 0; j < boardSize; j++) {
                columns.add(new Cell());
            }
            cells.add(columns);
        }
    }

    private void addSnakes(int numberOfSnakes) {
        while (numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.size() * cells.size() - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.size() * cells.size() - 1);
            if (snakeTail >= snakeHead) {
                continue;
            }
            Jump snakeJump = new Jump(snakeHead, snakeTail);
            Cell cell = getCell(snakeHead);
            cell.setJump(snakeJump);
            numberOfSnakes--;
        }
    }

    private void addLadder(int numberOfLadder) {
        while (numberOfLadder > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.size() * cells.size() - 1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, cells.size() * cells.size() - 1);
            if (ladderStart >= ladderEnd) {
                continue;
            }
            Jump ladderJump = new Jump(ladderEnd, ladderStart);
            Cell cell = getCell(ladderEnd);
            cell.setJump(ladderJump);
            numberOfLadder--;
        }
    }

    Cell getCell(int playerPosition) {
        int boardRow = playerPosition / cells.size();
        int boardColumn = (playerPosition % cells.size());
        return cells.get(boardRow).get(boardColumn);
    }

}
