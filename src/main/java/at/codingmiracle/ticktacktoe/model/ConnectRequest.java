package at.codingmiracle.ticktacktoe.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ConnectRequest {
	private Player player;
	private String gameId;
}
