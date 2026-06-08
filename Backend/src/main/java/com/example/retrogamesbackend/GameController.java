package com.example.retrogamesbackend;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameRepository repository;

    public GameController(GameRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Game> getGames(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String dateFrom,
            @RequestParam(required = false) String dateTo
    ) {

        LocalDate from = null;
        LocalDate to = null;

        if (dateFrom != null && !dateFrom.isEmpty()) {
            from = LocalDate.parse(dateFrom);
        }

        if (dateTo != null && !dateTo.isEmpty()) {
            to = LocalDate.parse(dateTo);
        }

        return repository.filterGames(title, from, to);
    }

    @PostMapping
    public Game addGame(@RequestBody Game game) {

        return repository.save(game);
    }
}
