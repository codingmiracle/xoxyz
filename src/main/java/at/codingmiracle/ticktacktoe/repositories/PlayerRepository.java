package at.codingmiracle.ticktacktoe.repositories;

import at.codingmiracle.ticktacktoe.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {

}
