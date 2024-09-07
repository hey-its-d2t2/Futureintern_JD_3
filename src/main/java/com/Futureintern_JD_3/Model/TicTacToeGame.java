package com.Futureintern_JD_3.Model;

public class TicTacToeGame {

    private String[] board = new String[9];
    private String result = "";

    public TicTacToeGame() {
        for (int i = 0; i < 9; i++) {
            board[i] = "";  // Empty board at the start
        }
    }

    public String[] getBoard() {
        return board;
    }

    public String getResult() {
        return result;
    }

    public void makeMove(int cell, String currentPlayer) {
        if (isCellEmpty(cell)) {
            board[cell - 1] = currentPlayer;
            if (checkWin(currentPlayer)) {
                result = currentPlayer + " Wins!";
            } else if (isBoardFull()) {
                result = "It's a Draw!";
            }
        }
    }

    public boolean isCellEmpty(int cell) {
        return board[cell - 1].isEmpty();
    }

    private boolean isBoardFull() {
        for (String cell : board) {
            if (cell.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkWin(String currentPlayer) {
        // Define winning conditions
        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},  // Rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},  // Columns
                {0, 4, 8}, {2, 4, 6}  // Diagonals
        };

        for (int[] condition : winConditions) {
            if (board[condition[0]].equals(currentPlayer) &&
                    board[condition[1]].equals(currentPlayer) &&
                    board[condition[2]].equals(currentPlayer)) {
                return true;
            }
        }
        return false;
    }
}
