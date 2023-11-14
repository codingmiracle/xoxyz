package at.codingmiracle.ticktacktoe.controller;

import at.codingmiracle.ticktacktoe.dto.PlayerDto;
import at.codingmiracle.ticktacktoe.dto.PlayerResponse;
import at.codingmiracle.ticktacktoe.models.Player;
import at.codingmiracle.ticktacktoe.repositories.PlayerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private PlayerRepository playerRepository;

    @GetMapping("test")
    public PlayerResponse ResponseTestController() {
        return PlayerResponse.builder()
                .id(0)
                .name("david")
                .build();
    }

    @PostMapping("/")
    public ResponseEntity<Boolean> createNewPlayer(PlayerDto playerRequest) {
        Player player = Player.builder()
                .id(UUID.randomUUID())
                .name(playerRequest.getName())
                .build();
        try {
            playerRepository.save(player);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }

}
