package at.codingmiracle.ticktacktoe.controller;

import at.codingmiracle.ticktacktoe.schema.PlayerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @GetMapping("test")
    public PlayerResponse RespotestController() {
        return PlayerResponse.builder()
                .id(0)
                .name("david")
                .build();
    }
}
