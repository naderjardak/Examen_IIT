package io.microservice.userservice.Service.interfaces;

import io.microservice.userservice.entities.Games;

import java.util.List;

public interface IGameService {
    Games createGames(Games games);
    List<Games> getAllGames();
    Games getGamesById(Long id);
    Games updateGames(Games games);
    void deleteGames(Long id);

    List<Games> getGamesByIds(List<Long> gameIds);
}
