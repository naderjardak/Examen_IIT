package io.microservice.userservice.Service;

import io.microservice.userservice.repositories.GameRepository;
import io.microservice.userservice.Service.interfaces.IGameService;
import io.microservice.userservice.entities.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService implements IGameService {


    @Autowired
    GameRepository gamesRepository;

    @Override
    public Games createGames(Games games) {
        return gamesRepository.save(games);
    }

    @Override
    public List<Games> getAllGames() {
        return gamesRepository.findAll();
    }

    @Override
    public Games getGamesById(Long id) {
        return gamesRepository.findById(id).orElse(null);
    }

    @Override
    public Games updateGames(Games games) {
        return gamesRepository.save(games);
    }

    @Override
    public void deleteGames(Long id) {
        gamesRepository.deleteById(id);
    }

@Override
    public List<Games> getGamesByIds(List<Long> gameIds) {
        return gamesRepository.findAllByIdIn(gameIds);
    }
}
