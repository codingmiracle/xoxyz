package at.codingmiracle.ticktacktoe.model;

import at.codingmiracle.ticktacktoe.exception.GameException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

@Data
@Getter
@Setter
public class Game {
	private String id;
	private Player host;
	private Player guest;
	private Player winner;
	private GameStatus gameStatus;
	private PlayerTurn playerTurn;
	private GamePosition[][][] field;

	public Game() {
		init();
	}

	public Game(Player h) {
		init();
		host = h;
	}

	private void init() {
		id = UUID.randomUUID().toString();
		playerTurn = getRandomStartPlayer();
		gameStatus = GameStatus.NEW;
	}

	public void connect(Player p) throws GameException {
		if(host != null && p != null && guest == null && !host.equals(p)) {
			setGuest(p);
			setGameStatus(GameStatus.IN_PROGRESS);
			return;
		}
		throw new GameException("error_invalid_game_connection");
	}



	public boolean canMakeMove(Player p) {
		switch (playerTurn) {
			case HOST: return p.equals(host);
			case GUEST: return p.equals(guest);
		}
		return false;
	}

	private PlayerTurn getRandomStartPlayer() {
		return new Random().nextBoolean() ? PlayerTurn.HOST : PlayerTurn.GUEST;
	}

}
