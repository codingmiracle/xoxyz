package at.codingmiracle.ticktacktoe.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "player")
@Builder
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private UUID id;

    @Column(name = "player_name", length = 50)
    private String name;

    public Player(UUID uuid, String name) {
        setId(uuid);
        setName(name);
    }

    public Player() {

    }
}
