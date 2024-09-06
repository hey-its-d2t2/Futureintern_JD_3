package com.Futureintern_JD_3.Model;


import java.util.Random;

public class Game {
    private char[][] board;
    private char currentPlayer;
    private boolean gameActive;
    private String mode; // "2P" or "AI"

    public Game() {
        resetGame();
    }

    public void resetGame() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameActive = true;
    }

    public char[][] getBoard() {
        return board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameActive() {
        return gameActive;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
        resetGame();
    }

    public void makeMove(int row, int col) {
        if (gameActive && board[row][col] == '\0') {
            board[row][col] = currentPlayer;
            if (checkWin()) {
                gameActive = false;
            } else if (isBoardFull()) {
                gameActive = false;
            } else {
                if ("AI".equals(mode) && currentPlayer == 'X') {
                    aiMove();
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }
    }

    private boolean checkWin() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '\0' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != '\0' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        if (board[0][0] != '\0' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '\0' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private void aiMove() {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (board[row][col] != '\0');
        makeMove(row, col);
    }
}
