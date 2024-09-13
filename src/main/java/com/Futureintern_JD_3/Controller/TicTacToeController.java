package com.Futureintern_JD_3.Controller;

import com.Futureintern_JD_3.Model.TicTacToeGame;
import com.Futureintern_JD_3.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tic-tac-toe")
public class TicTacToeController {

    @Autowired
    private GameService gameService;

    private static final String[] PLAYERS = {"X", "O"};
    private String currentPlayer = "X";
    private boolean gameActive = true;

    @GetMapping
    public String getGame(Model model) {
        model.addAttribute("board", gameService.getGame().getBoard());
        model.addAttribute("currentPlayer", currentPlayer);
        model.addAttribute("gameActive", gameActive);
        model.addAttribute("result", gameService.getGame().getResult());
        return "index";
    }

    @PostMapping("/makeMove/{index}")
    @ResponseBody
    public TicTacToeGame makeMove(@PathVariable int index, @RequestParam String mode) {
        if (!gameActive || !gameService.getGame().isCellEmpty(index)) {
            return gameService.getGame();
        }

        gameService.makeMove(index, currentPlayer);

        if (!gameService.getGame().getResult().isEmpty()) {
            gameActive = false;
            gameService.getGame().setResult(gameService.getGame().getResult());
        } else if ("single".equals(mode)) {
            gameService.aiMove("O");
            if (!gameService.getGame().getResult().isEmpty()) {
                gameActive = false;
                gameService.getGame().setResult("Computer wins!");
            }
        } else {
            currentPlayer = PLAYERS[0].equals(currentPlayer) ? PLAYERS[1] : PLAYERS[0];
        }

        return gameService.getGame();
    }

    @PostMapping("/restart")
    @ResponseBody
    public TicTacToeGame restart() {
        gameService.resetGame();
        currentPlayer = "X";
        gameActive = true;
        return gameService.getGame();
    }
}
