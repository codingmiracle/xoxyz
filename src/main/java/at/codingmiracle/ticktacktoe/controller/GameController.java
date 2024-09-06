package at.codingmiracle.ticktacktoe.controller;

import at.codingmiracle.ticktacktoe.model.ConnectRequest;
import at.codingmiracle.ticktacktoe.model.Game;
import at.codingmiracle.ticktacktoe.model.Player;
import at.codingmiracle.ticktacktoe.service.GameService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/game")
public class GameController {
	private final GameService gameservice;
	private final SimpMessagingTemplate simpMessagingTemplate;

	@PostMapping("/new")
	public ResponseEntity<Game> createGame(@RequestBody Player player) {
		log.info("create game request: {}", player);
		return ResponseEntity.ok(gameservice.createGame(player));
	}

	@PostMapping("/connect")
	public ResponseEntity<Game> connect(@RequestBody ConnectRequest request) throws HttpClientErrorException {
		log.info("connect request: {}", request);
		return ResponseEntity.ok(gameservice.connectToGame(request.getPlayer(), request.getGameId()));
	}

	@PostMapping("/connect/random")
	public ResponseEntity<Game> connect(@RequestBody Player player) {
		log.info("connect random: {}", player);
		return ResponseEntity.ok(gameservice.connectToRandomGame(player));
	}
}
