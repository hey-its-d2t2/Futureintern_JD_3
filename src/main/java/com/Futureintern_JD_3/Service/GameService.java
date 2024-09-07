package com.Futureintern_JD_3.Service;

import com.Futureintern_JD_3.Model.TicTacToeGame;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {

    private TicTacToeGame game = new TicTacToeGame();

    public TicTacToeGame makeMove(int cell, String currentPlayer) {
        game.makeMove(cell, currentPlayer);
        return game;
    }

    public TicTacToeGame aiMove(String currentPlayer) {
        Random random = new Random();
        int move;
        do {
            move = random.nextInt(9) + 1;  // Random move from 1 to 9
        } while (!game.isCellEmpty(move));  // Ensure the move is valid
        game.makeMove(move, currentPlayer);
        return game;
    }
}

