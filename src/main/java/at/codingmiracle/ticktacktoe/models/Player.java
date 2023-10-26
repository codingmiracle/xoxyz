package at.codingmiracle.ticktacktoe.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "player_id")
    private UUID id;

    @Column(name = "player_name", length = 50)
    private String name;
}
