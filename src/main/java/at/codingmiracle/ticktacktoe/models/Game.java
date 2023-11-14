package at.codingmiracle.ticktacktoe.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "uuid")
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "host")
    private Player host;

    @ManyToOne
    @JoinColumn(name = "guest")
    private Player guest;
}
