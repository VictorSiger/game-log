package com.victor.game_log.controller;

import com.victor.game_log.infrastructure.entities.Game;
import com.victor.game_log.service.GameService;
import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GameController{
    private final GameService gameService;
    private final HandlerMapping resourceHandlerMapping;

    public GameController(GameService gameService, @Nullable HandlerMapping resourceHandlerMapping){
        this.gameService = gameService;
        this.resourceHandlerMapping = resourceHandlerMapping;
    }

    @PostMapping
    public ResponseEntity<Game> saveGame(@RequestBody Game game){
        return ResponseEntity.ok(gameService.createGame(game));
    }

    @PutMapping
    public ResponseEntity<Game> updateGame(@RequestBody Game game, @RequestParam("id")Long id){
        return ResponseEntity.ok(gameService.updateGame(id, game));
    }

    @GetMapping
    public ResponseEntity<List<Game>> listGames(){
        return ResponseEntity.ok(gameService.readAllGames());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Game>> getGame(@PathVariable Long id){
        return ResponseEntity.ok(gameService.readGameById(id));
    }

    @DeleteMapping
    public void deleteGame(@RequestParam("id")Long id){
        gameService.deleteById(id);
    }

}
