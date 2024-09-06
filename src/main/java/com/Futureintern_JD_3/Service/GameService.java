package com.Futureintern_JD_3.Service;

import com.Futureintern_JD_3.Model.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private Game game = new Game();

    public Game getGame() {
        return game;
    }

    public void makeMove(int row, int col) {
        game.makeMove(row, col);
    }

    public void resetGame() {
        game.resetGame();
    }

    public void setMode(String mode) {
        game.setMode(mode);
    }
}
