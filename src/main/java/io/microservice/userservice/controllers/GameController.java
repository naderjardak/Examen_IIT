package io.microservice.userservice.controllers;

import io.microservice.userservice.Service.interfaces.IGameService;
import io.microservice.userservice.entities.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    IGameService iGameService;

    @PostMapping("createGames")
    public ResponseEntity<Games> createGames(@RequestBody Games games) {
        Games createdGames = iGameService.createGames(games);
        return ResponseEntity.ok(createdGames);
    }

    @GetMapping("getAllGames")
    public ResponseEntity<List<Games>> getAllGames() {
        List<Games> games = iGameService.getAllGames();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/getGamesById")
    public ResponseEntity<Games> getGamesById(@RequestParam Long id) {
        Games games = iGameService.getGamesById(id);
        if (games != null) {
            return ResponseEntity.ok(games);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   /* @PutMapping("/{id}")
    public ResponseEntity<Games> updateGames(@PathVariable Long id, @RequestBody Games games) {
        Games existingGames = gamesService.getGamesById(id);
        if (existingGames != null) {
            games.setId(id);
            Games updatedGames = gamesService.updateGames(games);
            return ResponseEntity.ok(updatedGames);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
*/
    @DeleteMapping("/deleteGames")
    public ResponseEntity<Void> deleteGames(@RequestParam Long id) {
        iGameService.deleteGames(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/getGamesByIds")
    public ResponseEntity<List<Games>> getGamesByIds(@RequestParam List<Long> gameIds) {
        List<Games> games =iGameService.getGamesByIds(gameIds);
        return ResponseEntity.ok(games);
    }
}
