package tictactoe;

public class Board {
    private char[] cells;

    public Board() {
        cells = new char[9];
        reset();
    }

    public void reset() {
        for (int i = 0; i < 9; i++) {
            cells[i] = ' ';
        }
    }

    public boolean setCell(int index, char symbol) {
        if (cells[index] == ' ') {
            cells[index] = symbol;
            return true;
        }
        return false;
    }

    public char getCell(int index) {
        return cells[index];
    }

    public boolean isFull() {
        for (char c : cells) {
            if (c == ' ') return false;
        }
        return true;
    }
}
