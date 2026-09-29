package com.victor.game_log.service;

import com.victor.game_log.infrastructure.entities.Game;
import com.victor.game_log.infrastructure.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public Game createGame(Game game){
        return gameRepository.save(game);
    }

    public List<Game> readAllGames(){
        return gameRepository.findAll();
    }

    public Optional<Game> readGameById(Long id){
        return gameRepository.findById(id);
    }

    public Game updateGame(Long id, Game gameUpdated){
        Game isGameExist = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo " + id + " não encontrado!"));

        gameUpdated.setId(id);
        return gameRepository.save(gameUpdated);
    }

    public void deleteById(long id){
        gameRepository.deleteById(id);
    }

}
