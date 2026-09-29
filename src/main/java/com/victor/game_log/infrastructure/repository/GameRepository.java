package com.victor.game_log.infrastructure.repository;

import com.victor.game_log.infrastructure.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
        }