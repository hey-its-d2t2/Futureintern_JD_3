package com.Futureintern_JD_3.Controller;

import com.Futureintern_JD_3.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tictactoe")
public class TicTacToeController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public String getGame(Model model) {
        model.addAttribute("game", gameService.getGame());
        return "game";
    }

    @PostMapping("/move")
    public String makeMove(@RequestParam int row, @RequestParam int col) {
        gameService.makeMove(row, col);
        return "redirect:/tictactoe";
    }

    @PostMapping("/reset")
    public String resetGame() {
        gameService.resetGame();
        return "redirect:/tictactoe";
    }
}