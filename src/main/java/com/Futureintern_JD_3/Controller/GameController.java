package com.Futureintern_JD_3.Controller;

package com.example.tictactoe.controller;

import com.example.tictactoe.model.TicTacToeGame;
import com.example.tictactoe.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public String homePage() {
        return "index";  // Redirect to the home page
    }

    @PostMapping("/playerMove")
    public String playerMove(@RequestParam("cell") int cell, @RequestParam("currentPlayer") String currentPlayer, Model model) {
        TicTacToeGame game = gameService.makeMove(cell, currentPlayer);
        model.addAttribute("board", game.getBoard());
        model.addAttribute("result", game.getResult());
        return "index";  // Return the updated game board
    }

    @PostMapping("/aiMove")
    public String aiMove(@RequestParam("currentPlayer") String currentPlayer, Model model) {
        TicTacToeGame game = gameService.aiMove(currentPlayer);
        model.addAttribute("board", game.getBoard());
        model.addAttribute("result", game.getResult());
        return "index";  // Return updated board after AI's move
    }
}
