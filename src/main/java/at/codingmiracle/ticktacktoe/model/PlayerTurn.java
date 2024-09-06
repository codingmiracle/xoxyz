package at.codingmiracle.ticktacktoe.model;

public enum PlayerTurn {
	HOST, GUEST;

	public static PlayerTurn next(PlayerTurn currentTurn) {
		switch (currentTurn) {
			case HOST -> {return GUEST;}
			case GUEST -> {return HOST;}
			default -> throw new RuntimeException("No player specified");
		}
	}
}
