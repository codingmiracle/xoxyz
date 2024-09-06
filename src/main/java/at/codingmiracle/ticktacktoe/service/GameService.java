package at.codingmiracle.ticktacktoe.service;

import at.codingmiracle.ticktacktoe.exception.GameException;
import at.codingmiracle.ticktacktoe.model.Game;
import at.codingmiracle.ticktacktoe.model.GameStatus;
import at.codingmiracle.ticktacktoe.model.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class GameService {
	private Set<Game> games;
	GameService() {
		games = new HashSet<>();
	}

	public Game createGame(Player player) {
		Game game = new Game(player);
		log.info("Creating game {}", game.getId());
		games.add(game);
		return game;
	}

	public Game connectToGame(Player guest, String gameId) throws GameException {
		Optional<Game> game = games.stream().filter(it -> Objects.equals(it.getId(), gameId)).findFirst();
		if(game.isPresent()) {
			log.info("Joining game {}", game.get().getId());
			game.get().connect(guest);
			return game.get();
		}
		throw new GameException("error_game_not_found");
	}

	public Game connectToRandomGame(Player guest) throws GameException {
		Optional<Game> game = games.stream().filter(it -> it.getGameStatus().equals(GameStatus.NEW)).findAny();
		if(game.isPresent()) {
			log.info("Joining game {}", game.get().getId());
			game.get().connect(guest);
			return game.get();
		}
		throw new GameException("error_games_not_avialable");
	}
}
